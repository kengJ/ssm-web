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

    @Override
    public ExcelLog findExcelLogAndNoUse(String id) {
        return excelLogDao.findExcelLogAndNoUse(id);
    }
    @Override
    public ExcelLog insertLog(Map<String, Object> excelmap) {
        ExcelLog excelLog = new ExcelLog();
        excelLog.setAction((String) excelmap.get("action"));
        excelLog.setData((String)excelmap.get("data"));
        excelLog.setDate((String)excelmap.get("date"));
        excelLog.setName((String)excelmap.get("name"));
        excelLog.setParms((String)excelmap.get("parms"));
        excelLogDao.insertLog(excelLog);
        return excelLog;
    }
    @Override
    public void updateUseLog(String id) {
        excelLogDao.updateUseLog(id);
    }
}
