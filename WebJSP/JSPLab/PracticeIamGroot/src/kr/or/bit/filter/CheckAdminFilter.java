package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/main/*", "/register.html"})
public class CheckAdminFilter implements Filter {
  public CheckAdminFilter() {
  }

  public void destroy() {
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    String isLogin = (String) session.getAttribute("login");
    if (isLogin == null) {
      isLogin = "false";
    }
    
    if (isLogin.equals("false")) {
      String msg = "잘못된 접근입니다.";
      String url = "../login.html";
      System.out.println(url);
      request.setAttribute("msg", msg);
      request.setAttribute("url", url);
      RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/redirect.jsp");
      dis.forward(request, response);
    }
    
    chain.doFilter(request, response);
  }

  public void init(FilterConfig fConfig) throws ServletException {
  }

}
