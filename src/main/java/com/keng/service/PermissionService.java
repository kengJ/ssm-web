package com.keng.service;

import com.keng.model.Permission;
import com.keng.model.User;

import java.util.List;

/**
 * FileName: PermissionService
 *
 * @author heyanzhu
 * @create 2018/10/12 11:59
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface PermissionService {
    Permission queryRootPermission();

    List<Permission> queryChildPermissions(Integer pid);

    List<Permission> queryAll();

    void insertPermission(Permission permission);

    Permission queryPermissionById(Integer id);

    void updatePermission(Permission permission);

    List<Integer> queryPermissionidsByRoleid(Integer roleid);

    List<Permission> queryPermissionForUser(User dbUser);
}
