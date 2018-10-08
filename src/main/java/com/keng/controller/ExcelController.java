package com.keng.controller;

import com.keng.model.ExcelLog;
import com.keng.service.ExcelService;
import com.keng.util.JsonHelper;
import com.keng.web.ViewExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: ExcelController
 *
 * @author: keng
 * Date:     2018/10/7 22:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Controller
@RequestMapping(value="/Excel")
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @RequestMapping(value="/PrintExcel")
    public ModelAndView PrintExcel(String Id){
        ExcelLog excelLog = excelService.findExcelLogAndNoUse(Id);
        String json = excelLog.getData();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", JsonHelper.stringToMap(json));
        excelService.updateUseLog(Id);
        return new ModelAndView(new ViewExcel(),result);
    }

}
