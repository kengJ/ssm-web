package com.keng.controller;

import com.keng.bean.AjaxResult;
import com.keng.model.DbMessage;
import com.keng.model.ExcelLog;
import com.keng.service.DbService;
import com.keng.service.ExcelService;
import com.keng.service.TxService;
import com.keng.util.FileReaderHelper;
import com.keng.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: DbController
 *
 * @author: keng
 * Date:     2018/10/7 22:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@Controller
@RequestMapping(value="/Db")
public class DbController {
    @Autowired
    private DbService dbService;
    @Autowired
    private TxService txService;
    @Autowired
    private ExcelService excelService;

    @ResponseBody
    @RequestMapping(value="/FindAllDb")
    public List<DbMessage> findAllDb(){
        return dbService.findAllDb();
    }

    @ResponseBody
    @RequestMapping(value="/FindByName")
    public List<DbMessage> findByName(String name){
        return dbService.findByName(name);
    }

    @ResponseBody
    @RequestMapping(value="/FindPersionMessage")
    public Map<String, Object> findPersionMessage(String code){
        return txService.findPersionMessage(code);
    }

    @ResponseBody
    @RequestMapping(value="/FindPersionMessageByDeptCode")
    public Map<String, Object> findPersionMessageByDeptCode(String deptCode){
        return txService.findPersionMessageByDeptCode(deptCode);
    }

    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value="/FindPersionMessageByCodeList")
    public Object findPersionMessageByCodeList(HttpServletRequest request){
        MultipartHttpServletRequest multipartRequest;
        multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile mFile;
        FileReaderHelper fileReaderHelper = null;
        mFile = multipartRequest.getFile("imgFile");
        if(mFile == null){
            return null;
        }
        if(! mFile.isEmpty()){
            InputStream inputStream = null;
            try {
                inputStream = mFile.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileReaderHelper = new FileReaderHelper(inputStream, true, true);
        }
        Map<String, Object> result = null;
        if (fileReaderHelper != null) {
            result = txService.findPersionMessageByCode(fileReaderHelper.getDataToArray());
        }
        //写入导出日志
        Map<String, Object> excelmap = new HashMap<String, Object>(5);
        excelmap.put("name", "人事信息查询导入列表");
        if (result != null) {
            excelmap.put("data", JsonHelper.excelMapToString((List<String[]>) result.get("data"), ""));
        }
        excelmap.put("action", "/FindPersionMessageByCodeList");
        excelmap.put("parms", "373918,");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        excelmap.put("date", sdf.format(new Date()));
        ExcelLog excelLog = excelService.insertLog(excelmap);
        AjaxResult ajax = new AjaxResult();
        ajax.setSuccess(true);
        ajax.setData(excelLog.getId());
        return ajax;
    }
}
