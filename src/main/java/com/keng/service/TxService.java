package com.keng.service;

import java.util.List;
import java.util.Map;

/**
 * FileName: TxService
 *
 * @author heyanzhu
 * @create 2018/10/5 17:21
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface TxService {
    /**
     * 根据工号查询信息
     * @param code 工号
     * @return 信息集合
     */
    Map<String, Object> findPersionMessage(String code);

    /**
     * 根据部门编号查询信息
     * @param deptCode 部门编号
     * @return 信息集合
     */
    Map<String, Object> findPersionMessageByDeptCode(String deptCode);

    /**
     * 根据工号批量查询信息
     * @param codelist 工号列表
     * @return 信息集合
     */
    Map<String, Object> findPersionMessageByCode(List<String> codelist);
}
