/**
 * FileName: RoleServiceImpl
 * Author:   keng
 * Date:     2018/10/7 22:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.keng.service.impl;

import com.keng.model.Role;
import com.keng.dao.RoleDao;
import com.keng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 〈〉
 * @author keng
 * @create 2018/10/7
 * @since 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> pageQueryData(Map<String, Object> map) {
        return roleDao.pageQueryData(map);
    }

    public int pageQueryCount(Map<String, Object> map) {
        return roleDao.pageQueryCount(map);
    }

    public List<Role> queryAll() {
        return roleDao.queryAll();
    }

    public void insertRolePermission(Map<String, Object> paramMap) {
        roleDao.deleteRolePermissions(paramMap);
        roleDao.insertRolePermission(paramMap);
    }
}
