package com.keng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * FileName: PermissionUrlController
 *
 * @author heyanzhu
 * @create 2018/10/19 14:02
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
@RequestMapping(value = "/PermissionUrl")
public class PermissionUrlController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "permissionUrl/index";
    }
}
