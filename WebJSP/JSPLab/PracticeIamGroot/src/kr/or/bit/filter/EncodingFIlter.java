package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = { "/*" }, initParams = {
    @WebInitParam(name = "encoding", value = "UTF-8", description = "UTF-8") })
public class EncodingFIlter implements Filter {
  private String encoding;

  public EncodingFIlter() {

  }

  public void destroy() {

  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    request.setCharacterEncoding(encoding);
    chain.doFilter(request, response);
  }

  public void init(FilterConfig fConfig) throws ServletException {
    encoding = fConfig.getInitParameter("encoding");
  }

}
