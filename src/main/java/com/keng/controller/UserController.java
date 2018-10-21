package com.keng.controller;

import com.keng.bean.AjaxResult;
import com.keng.model.Role;
import com.keng.model.User;
import com.keng.service.RoleService;
import com.keng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.SimpleDateFormat;
import java.util.*;

import com.keng.bean.Page;

/**
 * FileName: UserController
 *
 * @author: keng
 * Date:     2018/10/7 22:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Controller
@RequestMapping(value="/User")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/Deletes")
    @ResponseBody
    public Object deletes(Integer[] userid) {
        AjaxResult result = new AjaxResult();

        try {
            Map<String, Object> map = new HashMap<String, Object>(1);
            map.put("userids", userid);
            userService.deleteUsers(map);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @RequestMapping(value="/Delete")
    @ResponseBody
    public Object delete(String id) {
        AjaxResult result =  new AjaxResult();
        try {
            userService.delete(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/Update")
    public Object update(User user) {
        AjaxResult result = new AjaxResult();
        try {
            userService.updateUser(user);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value="/Edit")
    public String edit(String id, Model model) {
        User user = userService.queryById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @ResponseBody
    @RequestMapping(value="/Insert")
    public Object insert(User user) {
        AjaxResult result = new AjaxResult();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setCreatetime(sdf.format(new Date()));
            user.setUserpswd("123456");
            userService.insertUser(user);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value="/Add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/Index")
    public String index() {
        return "user/index";
    }

    @ResponseBody
    @RequestMapping(value="/PageQuery")
    public Object pageQuery( String queryText, Integer pageno, Integer pagesize ) {

        AjaxResult result = new AjaxResult();

        try {

            // 分页查询
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", (pageno-1)*pagesize);
            map.put("size", pagesize);
            map.put("queryText", queryText);

            List<User> users = userService.pageQueryData( map );
            // 当前页码
            // 总的数据条数
            int totalsize = userService.pageQueryCount( map );
            // 最大页码（总页码）
            int totalno = 0;
            if ( totalsize % pagesize == 0 ) {
                totalno = totalsize / pagesize;
            } else {
                totalno = totalsize / pagesize + 1;
            }

            // 分页对象
            Page<User> userPage = new Page<User>();
            userPage.setDatas(users);
            userPage.setTotalno(totalno);
            userPage.setTotalsize(totalsize);
            userPage.setPageno(pageno);

            result.setData(userPage);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "/Assign")
    public String assign(Integer id ,Model model){
        //用户信息
        User user = userService.queryById(id.toString());
        List<Role> roles = roleService.queryAll();

        //已分配权限
        List<Role> assignedRoles = new ArrayList<>();
        //未分配权限
        List<Role> unassignRoles = new ArrayList<>();

        //获取关系表的数据
        List<Integer> roleids =  userService.queryRoleidsByUserid(id);

        for(Role role : roles){
            if(roleids.contains(role.getId())){
                assignedRoles.add(role);
            }else{
                unassignRoles.add(role);
            }
        }
        model.addAttribute("assignedRoles",assignedRoles);
        model.addAttribute("unassignRoles",unassignRoles);
        model.addAttribute("user",user);
        //model.addAttribute("roles",roles);
        return "user/assign";
    }

    @ResponseBody
    @RequestMapping("/doAssign")
    public Object doAssign( Integer userid, Integer[] unassignroleids ) {
        AjaxResult result = new AjaxResult();

        try {
            // 增加关系表数据
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userid", userid);
            map.put("roleids", unassignroleids);
            userService.insertUserRoles(map);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/dounAssign")
    public Object dounAssign( Integer userid, Integer[] assignroleids ) {
        AjaxResult result = new AjaxResult();

        try {
            // 删除关系表数据
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userid", userid);
            map.put("roleids", assignroleids);
            userService.deleteUserRoles(map);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }
}
