package com.keng.dao;

import com.keng.model.AntiterroristMessage;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * FileName: AntiterroristMessageDao
 *
 * @author heyanzhu
 * @create 2018/10/9 15:33
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface AntiterroristMessageDao {
    @Select("select * from antiterroristmessage order by id")
    List<AntiterroristMessage> findAll();
}
