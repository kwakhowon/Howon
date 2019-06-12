package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("index.htm")
	public String index() {
		
		//Tiles 이전 (페이지 주소)
		//return "index.jsp";
		
		  return "home.index"; //Tiles 설정 <definition name="home.*"
	}
}
