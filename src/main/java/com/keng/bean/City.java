package com.keng.bean;
/**
 * FileName: City
 * @author heyanzhu
 * Date:     2018/10/5 9:21
 * Description: 用于身份证信息保存身份编码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class City {
    private int id;
    private String name;
    private int parentId;
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
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
