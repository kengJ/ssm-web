package com.keng.service.impl;

import com.keng.model.User;
import com.keng.dao.UserDao;
import com.keng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * FileName: UserServiceImpl
 *
 * @author: keng
 * Date:     2018/10/7 22:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryAll() {
        return userDao.queryAll();
    }

    public User queryForLogin(User user) {
        return userDao.queryForLogin(user);
    }

    public List<User> pageQueryData(Map<String, Object> map) {
        return userDao.pageQueryData(map);
    }

    public int pageQueryCount(Map<String, Object> map) {
        return userDao.pageQueryCount(map);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public User queryById(String id) {
        return userDao.queryById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void delete(String id) {
        userDao.delete(id);
    }

    public void deleteUsers(Map<String, Object> map) {
        userDao.deleteUsers(map);
    }
}
