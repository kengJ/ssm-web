package com.keng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FileName: ExcelPageController
 * 导出页面跳转控制器
 * @author heyanzhu
 * @create 2018/10/9 8:23
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
@Controller
@RequestMapping(value = "/excelPage")
public class ExcelPageController {

    /**
     * 反恐导出页面
     * @return 导出页面
     */
    @RequestMapping(value = "/antiterrorist")
    public String antiterrorist(){
        return "excel/antiterrorist";
    }
}
