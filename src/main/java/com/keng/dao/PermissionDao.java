package com.keng.dao;

import com.keng.model.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * FileName: PermissionDao
 *
 * @author heyanzhu
 * @create 2018/10/12 11:59
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface PermissionDao {
    @Select("select * from t_permission where pid is null")
    Permission queryRootPermission();

    @Select("select * from t_permission where pid = #{pid}")
    List<Permission> queryChildPermissions(Integer pid);

    @Select("select * from t_permission")
    List<Permission> queryAll();

    void insertPermission(Permission permission);

    @Select("select * from t_permission where id = #{id}")
    Permission queryPermissionById(Integer id);

    void updatePermission(Permission permission);

    @Select("select permissionid from t_role_permission where roleid =  #{roleid}")
    List<Integer> queryPermissionidsByRoleid(Integer roleid);
}
