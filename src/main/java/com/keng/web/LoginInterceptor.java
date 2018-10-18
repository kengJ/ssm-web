package com.keng.web;

import com.keng.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * FileName: LoginInterceptor
 * 登陆拦截器
 * @author: keng
 * Date:     2018/10/18 21:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 功能描述: <br>
     * 〈〉
     * 控制器执行前完成业务操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前的用户是否已经登陆
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if (user == null){
            String path = session.getServletContext().getContextPath();
            response.sendRedirect(path + "/Login");
            return false;
        }else {
            return true;
        }
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * 在控制器执行完成后进行的业务操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 功能描述: <br>
     * 〈〉
     * 在完成视图的渲染后进行的业务操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
