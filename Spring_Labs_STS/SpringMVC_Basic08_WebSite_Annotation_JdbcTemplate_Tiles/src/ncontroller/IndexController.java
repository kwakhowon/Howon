package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index.htm")
	public String index() {
		//return "index.jsp";  Tiles 적용전
		
		return "home.index";
		//name="home.*"
	}
}
