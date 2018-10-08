package com.keng.dao;

import com.keng.model.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * FileName: RoleDao
 * 权限 dao
 * @author heyanzhu
 * @create 2018/10/5 15:38
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface RoleDao {
    /**
     * 查询数据
     * @param map 参数
     * @return 权限列表
     */
    List<Role> pageQueryData(Map<String, Object> map);

    /**
     * 查询数据条数
     * @param map 参数
     * @return 数据条数
     */
    int pageQueryCount(Map<String, Object> map);

    /**
     * 查询所有的权限信息
     * @return 权限列表
     */
    @Select("select * from t_role")
    List<Role> queryAll();

    /**
     * 插入权限信息
     * @param paramMap 参数
     */
    void insertRolePermission(Map<String, Object> paramMap);

    /**
     * 删除权限信息
     * @param paramMap 参数
     */
    void deleteRolePermissions(Map<String, Object> paramMap);
}
