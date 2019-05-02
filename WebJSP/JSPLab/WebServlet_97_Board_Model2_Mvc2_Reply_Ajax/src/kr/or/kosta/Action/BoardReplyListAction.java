package kr.or.kosta.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.boarddao;
import kr.or.kosta.dto.reply;
import net.sf.json.JSONArray;

public class BoardReplyListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("replylist들어옴");
		String idx = request.getParameter("idx");
		String ps = request.getParameter("ps");
		String cp = request.getParameter("cp");
		List<reply> replylist = null;
		
		try {
			boarddao dao = new boarddao();
			replylist = dao.replylist(idx);
			System.out.println(1);
			JSONArray jsonarray = JSONArray.fromObject(replylist);
			System.out.println(2);
			request.setAttribute("jsonarray", jsonarray);
			System.out.println(3);
			System.out.println("오니? " +jsonarray);
		}catch(Exception e) {
			System.out.println("에러뜬다");
		}finally {
			
		}
		ActionForward forward = new ActionForward();
		forward.setPath("/board/replyjson.jsp");
		
		return forward;
	}

}
