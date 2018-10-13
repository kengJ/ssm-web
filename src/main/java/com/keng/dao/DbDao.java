package com.keng.dao;

import com.keng.bean.VisitorRoom;
import org.apache.ibatis.annotations.Select;
import com.keng.model.DbMessage;
import java.util.List;

/**
 * FileName: DbDao
 *
 * @author heyanzhu
 * @create 2018/10/5 15:28
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface DbDao {
    /**
     * 查询所有数据库信息
     * @return 数据库列表
     */
    @Select("select * from t_dbmessage")
    List<DbMessage> findAllDb() ;

    /**
     * 按名称查询数据库信息
     * @param name 数据库名称关键字
     * @return 数据库列表
     */
    @Select("select * from t_dbmessage where name like concat('%',#{name},'%')")
    List<DbMessage> findByName(String name);

}
