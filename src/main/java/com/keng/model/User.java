package com.keng.model;

/**
 * FileName: User
 * 用户模型
 * @author heyanzhu
 * @create 2018/10/5 9:45
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class User {
    private Integer id;
    private String username;
    private String loginacct;
    private String userpswd;
    private String email;
    private String createtime;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getLoginacct() {
        return loginacct;
    }
    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct;
    }
    public String getUserpswd() {
        return userpswd;
    }
    public void setUserpswd(String userpswd) {
        this.userpswd = userpswd;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCreatetime() {
        return createtime;
    }
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", loginacct=" + loginacct + ", userpswd=" + userpswd
                + ", email=" + email + "]";
    }
}
