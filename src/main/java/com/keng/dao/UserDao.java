package com.keng.dao;

import com.keng.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * FileName: UserDao
 * 用户 dao
 * @author heyanzhu
 * @create 2018/10/5 15:45
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface UserDao {
    /**
     * 查询所有用户
     * @return 用户列表
     */
    @Select("select * from t_user")
    List<User> queryAll();

    /**
     * 查询账号密码是否匹配
     * @param user 用户对象
     * @return 用户信息
     */
    @Select("select Id as id,UserName as username,loginacct	,userpswd from t_user where loginacct = #{loginacct} and userpswd = #{userpswd}")
    User queryForLogin(User user);

    /**
     * 按条件查询
     * @param map 参数
     * @return 用户列表
     */
    List<User> pageQueryData(Map<String, Object> map);

    /**
     * 查询数据条数
     * @param map 参数
     * @return 数据条数
     */
    int pageQueryCount(Map<String, Object> map);

    /**
     * 插入用户
     * @param user 用户信息
     */
    void insertUser(User user);
    @Select("select * from t_user where id = #{id}")
    User queryById(String id);

    /**
     * 更新用户信息
     * @param user 用户信息
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
}
