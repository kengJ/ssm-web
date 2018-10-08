package com.keng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FileName: ConsumeControlController
 *
 * @author: keng
 * Date:     2018/10/7 22:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Controller
@RequestMapping(value="/ConsumeControl")
public class ConsumeControlController {
    @RequestMapping(value="/Index")
    public String Index(){
        return "Consume/index";
    }
}
