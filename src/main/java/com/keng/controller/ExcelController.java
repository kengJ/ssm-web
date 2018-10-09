package com.keng.controller;

import com.keng.model.ExcelLog;
import com.keng.service.ExcelService;
import com.keng.util.JsonHelper;
import com.keng.web.ViewExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 反恐导出
     * @return 导出视图
     */
    @RequestMapping(value="/antiterrorist",method = RequestMethod.POST)
    public String antiterrorist(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        Date startDate;
        Date endDate;
        String startDateText = request.getAttribute("startDate").toString();
        String endDateText = request.getAttribute("endDateText").toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = sdf.parse(startDateText);
            endDate = sdf.parse(endDateText);
        }catch (Exception e){
            System.out.println("ExcelController.antiterrorist() 日期转换异常"+e);
        }


        return "success";
    }
}
