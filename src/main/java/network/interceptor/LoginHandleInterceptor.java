package network.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandleInterceptor implements HandlerInterceptor {
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        String tempContextUrl = requestURL.delete(requestURL.length() - request.getRequestURI().length(), requestURL.length()).append("/").toString();
        String requestURI = request.getRequestURI();

        //说明处在编辑的页面
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String usertype = (String) session.getAttribute("type");
        if (username != null) {
            if (requestURI.contains("teacher") && !usertype.equals("admin")) {
                response.sendRedirect(tempContextUrl + "network/adminLogin/adminLogin.do");
                return false;
            }else {
                //登陆成功的用户
                return true;
            }
        } else {
            //没有登陆，转向登陆界面
            if (requestURI.contains("teacher"))
                response.sendRedirect(tempContextUrl + "network/adminLogin/adminLogin.do");
            else
                response.sendRedirect(tempContextUrl + "network/manage/login.do");
            return false;
        }
    }
}
