package com.keng.service;

import com.keng.model.Role;
import java.util.List;
import java.util.Map;

/**
 * FileName: RoleService
 *
 * @author heyanzhu
 * @create 2018/10/5 17:19
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface RoleService {
    /**
     *
     * @param map 参数
     * @return 权限列表
     */
    List<Role> pageQueryData(Map<String, Object> map);

    /**
     *
     * @param map 参数
     * @return 数据条数
     */
    int pageQueryCount(Map<String, Object> map);

    /**
     *
     * @return 权限列表
     */
    List<Role> queryAll();

    /**
     *
     * @param paramMap 参数
     */
    void insertRolePermission(Map<String, Object> paramMap);
}
