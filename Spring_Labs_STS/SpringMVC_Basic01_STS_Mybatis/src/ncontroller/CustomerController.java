package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	/* Mybatis 사용 구현 객체는 (x)
	private NoticeDao noticedao;
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	*/
	
	private SqlSession sqlsession;
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	
	
	
	//글 목록보기
	//******************************************************************
	//메소드의 리턴 타입이 [String]이면 [리턴 값]은 [뷰 이름]으로 사용된다
	//View 에 데이터 전달 위해 Model interface 사용
	//Model model > 함수의 parameter 사용시 자동 객체 생성  > Spring ....
	


	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q , Model model) {
		
		int page=1;
		String field="TITLE";
		String query="%%";
				
		//조건 조합
		if(pg != null && !pg.equals("")) {
			page = Integer.parseInt(pg);
		}
				
		if(f != null && !f.equals("")) {
			field = f;
		}
				
		if(q != null && !q.equals("")) {
			query = q;
		}

		//System.out.println(page + field + query);
		//DAO 객체 생성 ... 함수 호출
		List<Notice> list=null;
		try {
			NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
			list = noticedao.getNotices(page, field, query);
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		//1.ModelAndView
		//ModelAndView 객체 사용가능
		//return new ModelAndView
		
		//Model : 데이터 담기
		//return :view 주소 
		model.addAttribute("list", list); //View 단 페이지에 자동 forward (list 이름으로)
		
		//return "notice.jsp";
		return "customer.notice";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {
		
		Notice notice=null;
		try {
			NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
			notice = noticedao.getNotice(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		model.addAttribute("notice", notice);
		
		//return "noticeDetail.jsp";
		return "customer.noticeDetail";
	}
	
	//월요일 수업 ... 오늘 과제 미리.....
	//글쓰기 화면 GET
	//@RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	//글쓰기 처리 POST (파일업로드)
	//@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	//글삭제하기
	//hint) location.href 
	//return "redirect:notice.htm"
	
	//form() : 화면
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	public String noticeReg() {
		
		//return "noticeReg.jsp";
		return "customer.noticeReg";
	}
	
	//submit()
	//데이터 insert 처리
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
		//private List<CommonsMultipartFile> files;
		//files[0] >> a.jpg
		//files[1] >> b.jpg
		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); //파일명
		
		if(files != null && files.size() > 0) { //1 개라도  업로드
			for(CommonsMultipartFile multifile : files) {
				String filename= multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				
				String fpath = path + "\\"+ filename; 
				
				if(!filename.equals("")) { //실 파일 업로드
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); //파일명을 별도로 ... DB insert
			}
		}
		
		//실 DB insert
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));
		
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.insert(n);
		return "redirect:notice.htm";
		
		
		//spring : "redirect:notice.htm" 
		
		//servlet
		//클라이언트 페이지 재 요청(F5 , 주소창에서 Enter)
		//location.href
		//response.sendredirect 

	}
	
	//글삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.delete(seq);
		return "redirect:notice.htm";
	}
	
	//글수정하기(화면 : select  .. where seq=?) :GET
	//notice = noticedao.getNotice(seq);
	//parameter (Model 객체 사용)
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.GET)
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
		
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		Notice notice = noticedao.getNotice(seq);
		model.addAttribute("notice", notice);
		//return "noticeEdit.jsp";
		return "customer.noticeEdit";
	}
	
	
	//글수정하기(DB Update ) : POST
	//파일업로드 처리 (INSERT  동일)
	//처리(update) -> noticeDetail 페이지 redirect 
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.POST)
	public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); //파일명
		
		if(files != null && files.size() > 0) { //1 개라도  업로드
			for(CommonsMultipartFile multifile : files) {
				String filename= multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				
				String fpath = path + "\\"+ filename; 
				
				if(!filename.equals("")) { //실 파일 업로드
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); //파일명을 별도로 ... DB insert
			}
		}
		
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));
		
		//DB 파일명 저장
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.update(n);
		return "redirect:noticeDetail.htm?seq="+n.getSeq();
	}
	
}






