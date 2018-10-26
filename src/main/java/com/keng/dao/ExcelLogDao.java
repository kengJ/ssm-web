package com.keng.dao;

import com.keng.model.ExcelLog;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * FileName: ExcelLogDao
 * excel 日志 dao
 * @author heyanzhu
 * @create 2018/10/5 15:33
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface ExcelLogDao {
    /**
     * 查询未使用的导出请求
     * @param id id
     * @return ExcelLog
     */
    ExcelLog findExcelLogAndNoUse(String id);

    /**
     * 插入日志信息
     * @param excelLog 导出日志
     */
    void insertLog(ExcelLog excelLog);

    /**
     * 更新日志信息
     * @param id id
     */
    @Update("update t_excellog set useflag = ifnull(useflag,0)+1,usedate = sysdate() where id = #{id}")
    void updateUseLog(String id);
}
