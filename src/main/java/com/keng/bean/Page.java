package com.keng.bean;

import java.util.List;

/**
 * FileName: Page
 * 分页信息模型
 * @author heyanzhu
 * @create 2018/10/5 9:44
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class Page<T> {
    private List<T> datas;

    private int pageno;

    private int totalno;

    private int totalsize;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getTotalno() {
        return totalno;
    }

    public void setTotalno(int totalno) {
        this.totalno = totalno;
    }

    public int getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(int totalsize) {
        this.totalsize = totalsize;
    }
}
