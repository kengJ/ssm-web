package com.keng.controller;

import com.keng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: TestController
 *
 * @author: keng
 * Date:     2018/10/7 23:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Controller
@RequestMapping(value="/Test")
public class TestController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value="/QueryAll")
    public Object queryAll(){
        return userService.queryAll();
    }

    @RequestMapping(value="/Index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value="/Json")
    public Object json(){
        Map<String,String> map = new HashMap<String, String>(1);
        map.put("username", "zhangsan");
        return map;
    }
}
