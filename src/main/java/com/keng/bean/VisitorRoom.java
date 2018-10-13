package com.keng.bean;

/**
 * FileName: VisitorRoom
 * 访客系统门设置模型
 * @author heyanzhu
 * @create 2018/10/13 8:33
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class VisitorRoom {
    private Integer tablerecid;
    private String userno ;
    private String computername;
    private String doorbillno;
    private String doorname;
    private Integer dktype;

    public Integer getTablerecid() {
        return tablerecid;
    }

    public void setTablerecid(Integer tablerecid) {
        this.tablerecid = tablerecid;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getComputername() {
        return computername;
    }

    public void setComputername(String computername) {
        this.computername = computername;
    }

    public String getDoorbillno() {
        return doorbillno;
    }

    public void setDoorbillno(String doorbillno) {
        this.doorbillno = doorbillno;
    }

    public String getDoorname() {
        return doorname;
    }

    public void setDoorname(String doorname) {
        this.doorname = doorname;
    }

    public Integer getDktype() {
        return dktype;
    }

    public void setDktype(Integer dktype) {
        this.dktype = dktype;
    }
}
