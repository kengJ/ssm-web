package com.keng.controller;

import com.keng.bean.AjaxResult;
import com.keng.model.Permission;
import com.keng.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: PermissionController
 * 许可维护控制器
 * @author heyanzhu
 * @create 2018/10/12 11:23
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/insert")
    @ResponseBody
    public Object insert( Permission permission){
        AjaxResult result = new AjaxResult();
        try {
            permissionService.insertPermission(permission);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public Object update(Permission permission){
        AjaxResult result = new AjaxResult();
        try {
            permissionService.updatePermission(permission);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "/add")
    public String add(){
        return "permission/add";
    }

    @RequestMapping(value = "/edit")
    public String edit(Integer id, Model model){
        Permission permission = permissionService.queryPermissionById(id);
        model.addAttribute("permission",permission);
        return "permission/edit";
    }

    /**
     * 跳转到许可维护首页
     * @return 视图文件
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "permission/index";
    }

    @RequestMapping(value = "loadData")
    @ResponseBody
    public Object loadData(){
        List<Permission> permissions = new ArrayList<>();
        //读取树形结构的数据
        //查询所有的许可
        List<Permission> ps = permissionService.queryAll();

        Map<Integer,Permission> permissionMap = new HashMap<>();
        for(Permission p : ps){
            permissionMap.put(p.getId(),p);
        }
        for(Permission p : ps){
            Permission child = p;
            if (child.getPid() == 0){
                permissions.add(p);
            }else{
                Permission parent = permissionMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }
        return permissions;
    }

    /**
     * 使用递归算法
     * 查询子节点
     * 注：递归算法会触发很多次的数据库查询，效率不高
     * @param parent 父节点
     */
    private void queryChildPermissions(Permission parent){
        List<Permission> childPermissions = permissionService.queryChildPermissions(parent.getId());
        for(Permission permission : childPermissions){
            queryChildPermissions(permission);
        }
        parent.setChildren(childPermissions);
    }
}
