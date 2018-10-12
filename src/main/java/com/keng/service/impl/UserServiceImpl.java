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

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }
    @Override
    public User queryForLogin(User user) {
        return userDao.queryForLogin(user);
    }
    @Override
    public List<User> pageQueryData(Map<String, Object> map) {
        return userDao.pageQueryData(map);
    }
    @Override
    public int pageQueryCount(Map<String, Object> map) {
        return userDao.pageQueryCount(map);
    }
    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
    @Override
    public User queryById(String id) {
        return userDao.queryById(id);
    }
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Override
    public void delete(String id) {
        userDao.delete(id);
    }
    @Override
    public void deleteUsers(Map<String, Object> map) {
        userDao.deleteUsers(map);
    }

    @Override
    public void deleteUserRoles(Map<String, Object> map) {
        userDao.deleteUserRoles(map);
    }

    @Override
    public void insertUserRoles(Map<String, Object> map) {
        System.out.println(map);
        userDao.insertUserRoles(map);
    }

    @Override
    public List<Integer> queryRoleidsByUserid(Integer userid) {
        return userDao.queryRoleidsByUserid(userid);
    }
}
