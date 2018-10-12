package com.keng.service;

import com.keng.model.User;
import java.util.List;
import java.util.Map;

/**
 * FileName: UserService
 *
 * @author heyanzhu
 * @create 2018/10/5 17:24
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface UserService {
    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> queryAll();

    /**
     * 登录检测
     * @param user 用户对象
     * @return 用户对象
     */
    User queryForLogin(User user);

    /**
     * 批量查询用户
     * @param map 参数
     * @return 用户列表
     */
    List<User> pageQueryData(Map<String, Object> map);

    /**
     * 查询用户条数
     * @param map 参数
     * @return 用户条数
     */
    int pageQueryCount(Map<String, Object> map);

    /**
     * 插入用户
     * @param user 用户对象
     */
    void insertUser(User user);

    /**
     * 按id查询用户
     * @param id id
     * @return 用户对象
     */
    User queryById(String id);

    /**
     * 更新用户
     * @param user 用户对象
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id id
     */
    void delete(String id);

    /**
     * 批量删除用户
     * @param map 参数
     */
    void deleteUsers(Map<String, Object> map);

    /**
     * 移除用户权限
     * @param map 参数
     */
    void deleteUserRoles(Map<String, Object> map);

    /**
     * 增加用户权限
     * @param map 参数
     */
    void insertUserRoles(Map<String, Object> map);

    List<Integer> queryRoleidsByUserid(Integer userid);
}
