package com.keng.service.impl;

import com.keng.dao.AntiterroristComputerDao;
import com.keng.dao.AntiterroristMessageDao;
import com.keng.model.AntiterroristComputer;
import com.keng.model.AntiterroristMessage;
import com.keng.service.AntiterroristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * FileName: AntiterroristServiceImpl
 *
 * @author heyanzhu
 * @create 2018/10/9 15:23
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名          修改时间           版本号              描述
 **/
@Service
public class AntiterroristServiceImpl implements AntiterroristService {

    @Autowired
    private AntiterroristComputerDao antiterroristComputerDao;

    @Autowired
    private AntiterroristMessageDao antiterroristMessageDao;

    /**
     * 随机获取电脑名
     * @param num 需要的电脑名数
     * @return 电脑名列表
     */
    @Override
    public List<AntiterroristComputer> findComputerForRand(int num) {
        return antiterroristComputerDao.findComputerForRand(num);
    }

    @Override
    public List<AntiterroristMessage> findAllMessage() {
        return antiterroristMessageDao.findAll();
    }

    @Override
    public Map<String, Object> formatMap() {
        List<AntiterroristComputer> computers = findComputerForRand(7);
        List<AntiterroristMessage> messages = findAllMessage();

        return null;
    }
}
