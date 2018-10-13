package com.keng.service.impl;

import com.keng.bean.VisitorRoom;
import com.keng.dao.DbDao;
import com.keng.service.DbService;
import com.keng.util.DbHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.keng.model.DbMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<VisitorRoom> queryVisitorRoomAll() {
        DbMessage dbMessage = findByName("fk").get(0);
        DbHelper dbHelper = new DbHelper(dbMessage);
        dbHelper.createConn(dbMessage);
        String sql = "select convert(varchar(50),b.tablerecid) as tablerecid,\n" +
                "convert(varchar(50) ,b.userno) as userno,convert(varchar(50),b.computername) as computername,convert(varchar(50),b.doorbillno) as doorbillno,convert(varchar(50),c.doorname) as doorname,convert(varchar(50),c.dktype) as dktype from ba_usercomputer b inner join  fk_doorlist  c on b.doorbillno=c.doorbillno";
        Map<String,Object> result = dbHelper.findData(sql);
        List<String[]> data = (List<String[]>) result.get("data");
        List<VisitorRoom> resultData = new ArrayList<>();
        for(String[] line : data){
            if(!line[0].equals("tablerecid")) {
                VisitorRoom room = new VisitorRoom();
                room.setTablerecid(Integer.parseInt(line[0]));
                room.setUserno(line[1]);
                room.setComputername(line[2]);
                room.setDoorbillno(line[3]);
                room.setComputername(line[4]);
                room.setDoorname(line[5]);
                resultData.add(room);
            }
        }
        return resultData;
    }
}
