package com.keng.controller;

import com.keng.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FileName: FkController
 *
 * @author heyanzhu
 * @create 2018/10/13 9:00
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
@Controller
@RequestMapping(value = "/fk")
public class FkController {
    @Autowired
    private DbService dbService;

    @RequestMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("rooms",dbService.queryVisitorRoomAll());
        return "fk/index";
    }
}
