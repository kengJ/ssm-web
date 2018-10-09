package com.keng.service.impl;

import com.keng.dao.DbDao;
import com.keng.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import com.keng.model.DbMessage;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * FileName: DBServiceImpl
 *
 * @author heyanzhu
 * @create 2018/10/5 17:29
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
@Service
public class DbServiceImpl implements DbService {
    @Autowired
    private DbDao dbDao;

    @Override
    public List<DbMessage> findAllDb() {
        return dbDao.findAllDb();
    }

    @Override
    public List<DbMessage> findByName(String name) {
        return dbDao.findByName(name);
    }
}
