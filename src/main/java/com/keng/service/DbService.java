package com.keng.service;

import com.keng.bean.VisitorRoom;
import com.keng.model.DbMessage;
import java.util.List;

/**
 * FileName: DbService
 * 数据 service
 * @author heyanzhu
 * @create 2018/10/5 17:14
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface DbService {
    /**
     * 查询所有数据库信息
     * @return
     */
    List<DbMessage> findAllDb() ;

    /**
     * 根据关键字查询数据库信息
     * @param name
     * @return
     */
    List<DbMessage> findByName(String name);

    List<VisitorRoom> queryVisitorRoomAll();
}
