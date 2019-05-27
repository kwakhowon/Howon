package ncontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {
  private MemberDao memberdao;
  
  @Autowired
  public void setMemberdao(MemberDao memberdao) {
    this.memberdao = memberdao;
  }
  
  //회원가입 페이지
  @RequestMapping(value="join.htm", method=RequestMethod.GET)
  public String join() {
    
    return "join.jsp";
  }
  
  //회원가입처리
  @RequestMapping(value="join.htm", method=RequestMethod.POST)
  public String join(Member member) {
    
    try {
      memberdao.insert(member);
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return "redirect:/index.htm";
    //http://localhost:8090/SpringMVC_Basic06_WebSite_Annotation_jdbcTemplete/index.htm
  }
  
}
