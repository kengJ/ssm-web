package com.keng.model;

/**
 * FileName: ExcelLog
 * Excel 导出信息 日志模型
 * @author heyanzhu
 * @create 2018/10/5 9:42
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class ExcelLog {
    private int id;
    private String name;
    private String date;
    private String action;
    private String parms;
    private String data;
    private String useflag;
    private String usedate;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getParms() {
        return parms;
    }
    public void setParms(String parms) {
        this.parms = parms;
    }
    public String getUseflag() {
        return useflag;
    }
    public void setUseflag(String useflag) {
        this.useflag = useflag;
    }
    public String getUsedate() {
        return usedate;
    }
    public void setUsedate(String usedate) {
        this.usedate = usedate;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}

