package com.keng.controller;

import com.keng.model.Permission;
import com.keng.model.User;
import com.keng.service.PermissionService;
import com.keng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.keng.bean.AjaxResult;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: DispatcherController
 *
 * @author: keng
 * Date:     2018/10/7 22:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value="/Login")
    public String login() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value="/doAJAXLogin")
    public Object doAjaxLogin(User user, HttpSession session) {
        AjaxResult result = new AjaxResult();
        User dbUser = userService.queryForLogin(user);
        if(dbUser != null) {
            session.setAttribute("loginUser", dbUser);
            //获取权限信息
            List<Permission> permissions = permissionService.queryPermissionForUser(dbUser);
            Map<Integer,Permission> permissionMap = new HashMap<>(permissions.size());
            Permission root = null;
            for (Permission permission : permissions){
                permissionMap.put(permission.getId(),permission);
            }
            //root = permissionMap.get(0);
            for (Permission permission : permissions){
                Permission child = permission;
                if(child.getPid()==0){
                    root = permission;
                }else{
                    Permission parent = permissionMap.get(child.getPid());
                    parent.getChildren().add(child);
                }
            }
            session.setAttribute("rootPermission",root);
            result.setSuccess(true);
        }else {
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value="/Logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        session.invalidate();//��ȫ��session��ֵʧЧ
        return "redirect:/Login";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

}
