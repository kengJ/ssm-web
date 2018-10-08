package com.keng.controller;

import com.keng.bean.AjaxResult;
import com.keng.model.User;
import com.keng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Object deletes(Integer[] userId) {
        AjaxResult result = new AjaxResult();

        try {
            Map<String, Object> map = new HashMap<String, Object>(1);
            map.put("userids", userId);
            userService.deleteUsers(map);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @RequestMapping(value="/Delete")
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

    /**
     * 用户首页
     * @return 首页
     */
    @RequestMapping(value="/Index")
    public String index(@RequestParam(required=false,defaultValue="1")Integer pageno , @RequestParam(required=false,defaultValue="10")Integer pagesize , Model model){
        //分页查询
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put("start", (pageno-1)*pagesize);
        map.put("size", pagesize);
        List<User> users = userService.pageQueryData(map);
        model.addAttribute("users", users);
        model.addAttribute("pageno", pageno);

        int totalsize = userService.pageQueryCount(map);

        int totalno;
        if( totalsize % pagesize == 0 ) {
            totalno = totalsize / pagesize;
        }else {
            totalno = totalsize / pagesize + 1;
        }
        model.addAttribute("totalno", totalno);
        return "user/index";
    }

    @ResponseBody
    @RequestMapping(value="/PageQuery")
    public Object pageQuery(
            @RequestParam(required=false,defaultValue="1")Integer pageno ,
            @RequestParam(required=false,defaultValue="10")Integer pagesize ) {
        AjaxResult result = new AjaxResult();
        try {

            Map<String, Object> map = new HashMap<String, Object>(2);
            map.put("start", (pageno-1)*pagesize);
            map.put("size", pagesize);
            List<User> users = userService.pageQueryData(map);

            int totalsize = userService.pageQueryCount(map);

            int totalno ;
            if( totalsize % pagesize == 0 ) {
                totalno = totalsize / pagesize;
            }else {
                totalno = totalsize / pagesize + 1;
            }

            Page<User> userPage = new Page<User>();
            userPage.setPageno(pageno);
            userPage.setTotalno(totalno);
            userPage.setTotalsize(totalsize);
            userPage.setDatas(users);

            result.setData(userPage);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
