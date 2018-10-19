package com.keng.dao;

import com.keng.model.PermissionUrl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * FileName: PermissionUrlDao
 *
 * @author heyanzhu
 * @create 2018/10/19 13:50
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface PermissionUrlDao {
    @Select("select * from permissionUrl where permissionId = #{id}")
    List<PermissionUrl> queryPermissionUrlByPermissionId(Integer id);

    @Insert("insert into permissionUrl (permissionId,url) values (#{permissionUrl.permissionId},#{permissionUrl.url})")
    void insertPermissionUrl(PermissionUrl permissionUrl);

    @Delete("delete from permissionUrl where id = #{id}")
    void deletePermissionUrl(Integer id);

    @Update("update permissionUrl set permissionId = #{permissionUrl.permissionId},url = #{permissionUrl.url} where id = #{permissionUrl.id}")
    void updatePermissionUrl(PermissionUrl permissionUrl);
}
