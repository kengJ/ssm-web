package com.keng.service.impl;

import com.keng.model.DbMessage;
import com.keng.service.TxService;
import com.keng.util.DbHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.keng.service.DbService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * FileName: TxServiceImpl
 * @author:   keng
 * Date:     2018/10/7 22:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class TxServiceImpl implements TxService {

    @Autowired
    private DbService dbService;

    @Override
    public Map<String, Object> findPersionMessage(String code) {
        DbMessage dbMessage = dbService.findByName("tx").get(0);
        DbHelper dbHelper = new DbHelper(dbMessage);
        String sql ="select RTRIM(emp.code) as 工号,emp.name as 姓名,dpt.longname as 部门,RTRIM(emp.cardno) as 卡号,RTRIM(emp.card_sn) as 卡序列号"
                + ",isnull(emp.memo,'') as 备注 "
                + "from zlemployee  emp "
                + "left join zldept dpt on emp.dept = dpt.code "
                + "where emp.code = '"+code+"'";
        return dbHelper.findData(sql);
    }

    @Override
    public Map<String, Object> findPersionMessageByDeptCode(String deptCode) {
        DbMessage dbMessage = dbService.findByName("tx").get(0);
        DbHelper dbHelper = new DbHelper(dbMessage);
        String sql ="select RTRIM(emp.code) as 工号,emp.name as 姓名,dpt.longname as 部门,RTRIM(emp.cardno) as 卡号,RTRIM(emp.card_sn) as 卡序列号"
                + ",isnull(emp.memo,'') as 备注 "
                + "from zlemployee  emp "
                + "left join zldept dpt on emp.dept = dpt.code "
                + "where dpt.code = '"+deptCode+"'";
        return dbHelper.findData(sql);
    }

    @Override
    public Map<String, Object> findPersionMessageByCode(List<String> codelist) {
        DbMessage dbMessage = dbService.findByName("tx").get(0);
        DbHelper dbHelper = new DbHelper(dbMessage);
        StringBuilder codes = new StringBuilder();
        for(String code : codelist){
            codes.append("'").append(code).append("',");
        }
        String sql ="select RTRIM(emp.code) as 工号,emp.name as 姓名,dpt.longname as 部门,RTRIM(emp.cardno) as 卡号,RTRIM(emp.card_sn) as 卡序列号"
                + ",isnull(emp.memo,'') as 备注,CONVERT(varchar(15),emp.LzDate,23) as 离职日期 "
                + "from zlemployee  emp "
                + "left join zldept dpt on emp.dept = dpt.code "
                + "where emp.code in("+codes.substring(0,codes.length()-1)+")";
        System.out.println(sql);
        return dbHelper.findData(sql);
    }
}
