/**
 * FileName: ExcelServiceImpl
 * Author:   keng
 * Date:     2018/10/7 21:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.keng.service.impl;

import com.keng.model.ExcelLog;
import com.keng.dao.ExcelLogDao;
import com.keng.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 〈〉
 * @author keng
 * @create 2018/10/7
 * @since 1.0.0
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private ExcelLogDao excelLogDao;

    public ExcelLog findExcelLogAndNoUse(String id) {
        ExcelLog excelLog = excelLogDao.findExcelLogAndNoUse(id);
        return excelLog;
    }

    public ExcelLog insertLog(Map<String, Object> excelmap) {
        ExcelLog ExcelLog = new ExcelLog();
        ExcelLog.setAction((String) excelmap.get("action"));
        ExcelLog.setData((String)excelmap.get("data"));
        ExcelLog.setDate((String)excelmap.get("date"));
        ExcelLog.setName((String)excelmap.get("name"));
        ExcelLog.setParms((String)excelmap.get("parms"));
        excelLogDao.insertLog(ExcelLog);
        return ExcelLog;
    }

    public void updateUseLog(String id) {
        excelLogDao.updateUseLog(id);
    }
}
