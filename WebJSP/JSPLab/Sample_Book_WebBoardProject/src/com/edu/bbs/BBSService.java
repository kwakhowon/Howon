package com.edu.bbs;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public interface BBSService {
 
  public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
 
}
