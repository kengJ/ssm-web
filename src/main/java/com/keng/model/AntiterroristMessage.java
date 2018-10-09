package com.keng.model;

/**
 * FileName: AntiterroristMessageDao
 * 反恐附件 问题处理模型
 * @author heyanzhu
 * @create 2018/10/9 15:31
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class AntiterroristMessage {
    private int id;
    private String memo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
