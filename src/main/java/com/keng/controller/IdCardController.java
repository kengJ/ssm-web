package com.keng.controller;

import com.keng.bean.AjaxResult;
import com.keng.util.IdCardHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * FileName: IdCardController
 *
 * @author: keng
 * Date:     2018/10/7 22:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Controller
@RequestMapping(value="/IdCard")
public class IdCardController {
    @RequestMapping(value="/Index")
    public String index(){
        return "IdCard/Index";
    }

    @RequestMapping(value="/CheckByNo")
    @ResponseBody
    public Object checkByNo(String idCard){
        IdCardHelper idCardHelper = new IdCardHelper();
        AjaxResult result = new AjaxResult();
        Map<String, Object> checkData = idCardHelper.findMessage(idCard);
        boolean msg = Boolean.parseBoolean((String) checkData.get("msg"));
        if(msg){
            result.setSuccess(true);
            result.setData(checkData);
        }else{
            result.setSuccess(false);
        }
        return result;
    }
}
