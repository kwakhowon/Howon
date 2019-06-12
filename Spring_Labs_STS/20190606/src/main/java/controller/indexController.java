package controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.TestUserDao;
import dto.TestUser;

@Controller
public class indexController {
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	@RequestMapping("/index.htm")
	public String index() {
		return "home";
	}
	@RequestMapping(value="/login.htm", method=RequestMethod.GET)
	public String login() {
		return "Login";
	}
	
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public String login(String id, String password) {
		System.out.println("123");
		String viewpage = "";
		System.out.println("123");
		TestUserDao testUserDao = sqlsession.getMapper(TestUserDao.class);
		System.out.println("TestUserDao" + testUserDao);
		TestUser result = testUserDao.check(id, password);
		System.out.println("result" + result);
		if(result != null) {
			System.out.println("로그인 성공");
			HttpSession session = null;
			session.setAttribute("login", result);
			viewpage = "home";
		}else {
			System.out.println("로그인 실패");
			viewpage = "Login";
		}
		return viewpage;
	}
	@RequestMapping(value ="/register.htm", method=RequestMethod.GET)
	public String register() {
		return "Register";
	}
	
	@RequestMapping(value ="/register.htm", method=RequestMethod.POST)
	public String register(TestUser user) {
		TestUserDao testuserdao = sqlsession.getMapper(TestUserDao.class);
		testuserdao.insertUser(user);
		return "Login";
	}
	@RequestMapping(value="/emptable.htm")
	public String empTable() {
		return "empTable";
	}
}
