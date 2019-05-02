package com.edu.bbs;
 
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
public class BBSServlet extends HttpServlet {
 
  private static final long serialVersionUID = 1L;
  Properties properties;
  HashMap<String, BBSService> bbsMap;   // Upcasting : 부모 자리에 자식 올 수 있다.
  BBSService bbsService;
   
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("GET으로 요청");
    handling(req, resp);
  }
 
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("POST로 요청");
    handling(req, resp);
  }
 
  public void handling(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String servletPath = req.getServletPath();    // 서블릿경로만 뽑아냄, 하위에 쿼리 등 파라미터는 가져오지 않는다.
     
    String view = bbsMap.get(servletPath).bbsService(req, resp);
    System.out.println("view : " + view);
    if(view != null) {    // view가 null일 경우는 파일 다운로드에 페이지 이동 없는 것과 같은 경우
      RequestDispatcher reqDispatcher = req.getRequestDispatcher(view);
      reqDispatcher.forward(req, resp);   // 부모자리에 자식 올 수 있다(ServletRequest > HttpServletRequest)
    }
  }
 
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("Init...");
    properties = new Properties();
    bbsMap = new HashMap<>();
    String configPath = config.getInitParameter("bbsProperties"); // web.xml
    try {
      properties.load(new FileReader(configPath));
      Iterator<Object> iterator = properties.keySet().iterator();
      while(iterator.hasNext()) {
        String key = (String)iterator.next();
        String value = properties.getProperty(key);
         
//        Class instanceValue = Class.forName(value);
        Class<?> instanceValue = Class.forName(value);
        bbsService = (BBSService)instanceValue.newInstance();
        bbsMap.put(key, bbsService);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
   
}
