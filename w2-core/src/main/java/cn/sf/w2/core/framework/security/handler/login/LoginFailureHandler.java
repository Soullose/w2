package cn.sf.w2.core.framework.security.handler.login;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFailureHandler implements AuthenticationFailureHandler {
    /**
     * Called when an authentication attempt fails.
     *
     * @param request   the request during which the authentication attempt occurred.
     * @param response  the response.
     * @param exception the exception which was thrown to reject the authentication
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter out = response.getWriter();
        if (exception instanceof BadCredentialsException) {
            out.write("用户名或者密码输入错误，登录失败");
//            respBean.setMessage("用户名或者密码输入错误，登录失败");
        } else if (exception instanceof DisabledException) {
//            respBean.setMessage("账户被禁用，登录失败");
        } else if (exception instanceof CredentialsExpiredException) {
//            respBean.setMessage("密码过期，登录失败");
        } else if (exception instanceof AccountExpiredException) {
//            respBean.setMessage("账户过期，登录失败");
        } else if (exception instanceof LockedException) {
//            respBean.setMessage("账户被锁定，登录失败");
        }
    }
}
