package com.keng.util;

import com.keng.model.DbMessage;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: DbHelper
 * 数据库工具类
 * @author heyanzhu
 * @create 2018/10/5 10:14
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class DbHelper {
    private DbMessage dbMessage;

    private Connection dbConn=null;

    public DbMessage getDbMessage() {
        return dbMessage;
    }

    public void setDbMessage(DbMessage dbMessage) {
        this.dbMessage = dbMessage;
    }

    public DbHelper(DbMessage dbMessage) {
        super();
        this.dbMessage = dbMessage;
    }

    public DbHelper() {
    }

    public Map<String ,Object> findData(String sql){
        Map<String ,Object> result = new HashMap<>(2);
        try {
            //连接
            createConn(this.dbMessage);
            List<String[]> data = findDataBySql(sql);
            result.put("data", data);
            result.put("msg", "success");
        } catch (Exception e) {
            result.put("msg", "error:"+e.toString());
        }

        return result;
    }

    public void createConn(DbMessage dbMessage) {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = String.format("jdbc:sqlserver://%s:1433;DatabaseName=%s", dbMessage.getIp(), dbMessage.getDbName());
        String userName=dbMessage.getUsername();
        String userPwd=dbMessage.getPassword();
        try {
            Class.forName(driverName);
            this.dbConn= DriverManager.getConnection(dbURL,userName,userPwd);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动异常");
        } catch (SQLException e) {
            System.out.println("连接异常");
            System.out.println(e.toString());
        }
    }

    public List<String[]> findDataBySql(String sql) {
        //Connection dbConn = CreateConn(sqlMessage);
        Statement stmt = null;
        ResultSet result;
        ResultSetMetaData rsm;
        List<String[]> dataList = null;
        try {
            stmt = dbConn.createStatement();
            result = stmt.executeQuery(sql);
            rsm = result.getMetaData();
            dataList = new ArrayList<>();
            String[] dataTop = new String[rsm.getColumnCount()];
            for(int index = 1;index<=rsm.getColumnCount();index++) {
                dataTop[index-1] = rsm.getColumnName(index);
            }
            dataList.add(dataTop);
            while(result.next()) {
                String[] data = new String[rsm.getColumnCount()];
                for(int index = 1;index<=rsm.getColumnCount();index++) {
                    data[index-1] = result.getString(rsm.getColumnName(index));
                }
                dataList.add(data);
            }
        } catch (SQLException e) {
            System.out.println("查询异常"+e.toString());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                dbConn.close();
            } catch (SQLException e) {
                System.out.println("资源关闭异常");
            }

        }
        return dataList;

    }
}
