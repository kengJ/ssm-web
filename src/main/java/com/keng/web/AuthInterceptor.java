package com.keng.web;

import com.keng.model.Permission;
import com.keng.model.User;
import com.keng.service.PermissionService;
import org.activiti.engine.impl.interceptor.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FileName: AuthInterceptor
 * 权限拦截器
 * @author: keng
 * Date:     2018/10/18 22:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("loginUser");
        //如果是管理员直接跳过检测
        if ("admin".equals(user.getUsername())){
            return true;
        }
        String path = request.getSession().getServletContext().getContextPath();
        //获取当前用户的请求地址
        String uri = request.getRequestURI();
        System.out.println(uri);
        //判断当前路径是否需要权限验证
        List<Permission> permissions = permissionService.queryAll();
        Set<String> uriSet = new HashSet<>();
        for (Permission permission : permissions){
            if (permission.getUrl() != null && !"".equals(permission.getUrl())){
                String[] urls = permission.getUrl().split(";");
                for (String url : urls){
                    uriSet.add(path + url);
                }
            }
        }
        if (uriSet.contains(uri)){
            //权限验证
            Set<String> authUriSet = (Set<String>) request.getSession().getAttribute("authUriSet");
            if (authUriSet.contains(uri)){
                return true;
            }else{
                response.sendRedirect(path + "/error");
                return false;
            }
        }else {
            return false;
        }
    }
}
