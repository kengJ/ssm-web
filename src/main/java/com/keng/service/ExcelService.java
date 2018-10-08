package com.keng.service;

import com.keng.model.ExcelLog;

import java.util.Map;

/**
 * FileName: ExcelService
 *
 * @author heyanzhu
 * @create 2018/10/5 17:16
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface ExcelService {
    /**
     * 查询可使用的日志
     * @param id id
     * @return 日志对象
     */
    ExcelLog findExcelLogAndNoUse(String id);

    /**
     * 插入日志
     * @param excelmap 参数
     * @return 日志
     */
    ExcelLog insertLog(Map<String, Object> excelmap);

    /**
     * 更新日志信息
     * @param id id
     */
    void updateUseLog(String id);
}
