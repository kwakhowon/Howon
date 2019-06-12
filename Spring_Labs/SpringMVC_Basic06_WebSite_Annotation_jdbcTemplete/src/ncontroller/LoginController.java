package ncontroller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class LoginController {
  
  //로그인 페이지
  private MemberDao memberdao;
  
  @Autowired
  public void setMemberdao(MemberDao memberdao) {
    this.memberdao = memberdao;
  }


  @RequestMapping(value = "login.htm", method=RequestMethod.GET)
  public String login() {
    
    return "login.jsp";
  }
  
  @RequestMapping(value = "login.htm", method = RequestMethod.POST)
  public String login(String uid, HttpServletRequest request) throws ClassNotFoundException, SQLException {
    memberdao.getMember(uid);
    String id = request.getParameter("UserName");
    String pwd = request.getParameter("password");
    if(memberdao.getMember(uid).getUserid().equals(id) && memberdao.getMember(uid).getPwd().equals(pwd)) {
      return "redirect:/index.htm";
      
    }else {
      return "login.jsp";
    }
    
  }
}
