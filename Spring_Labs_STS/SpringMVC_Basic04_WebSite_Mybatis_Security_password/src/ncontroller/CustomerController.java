package ncontroller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

// > /customer/notice.htm 
// > /customer/noticeDetail.htm

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	@Autowired
	private SqlSession sqlsession;
	//org.mybatis.spring.SqlSessionTemplate 객체의 주소값
	

	// @RequestMapping("/customer/notice.htm")
	// jsp?pg=1&f=title&q=%가%
	// 글 목록 보기
	@RequestMapping("notice.htm")
	public String notices(String pg, String f, String q, Model model) throws ClassNotFoundException, SQLException {
		// System.out.println("************************");
		// 게시판 검색 설정을 위한 기본 값 설정
		int page = 1;
		String field = "TITLE";
		String query = "%%";

		// 조건 조합
		if (pg != null && !pg.equals("")) {
			page = Integer.parseInt(pg);
		}

		if (f != null && !f.equals("")) {
			field = f;
		}

		if (q != null && !q.equals("")) {
			query = q;
		}

		//기존 DAO
		/*List<Notice> list = noticedao.getNotices(page, field, query);*/
		
		//Mybatis
		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		List<Notice> list = noticeDao.getNotices(page, field, query);

		// ModelAndView 사용
		// Model
		model.addAttribute("list", list); // 자동 forward : view page (list 이름)

		//return "notice.jsp";
          return "customer.notice";
	}

	// 글 상세 보기
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq, Model model) throws ClassNotFoundException, SQLException {

		//Mybatis
		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		Notice notice = noticeDao.getNotice(seq);
		model.addAttribute("notice", notice);

		//return "noticeDetail.jsp";
		  return "customer.noticeDetail";
	}

	// 글쓰기 화면
	// @RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	@RequestMapping(value = "noticeReg.htm", method = RequestMethod.GET)
	public String noticeReg() {
		
		//return "noticeReg.jsp";
		return "customer.noticeReg";
	}

	// 글쓰기 (처리)
	// @RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	// public int insert(Notice n) ...
	// customer/upload 업로드 경로
	@RequestMapping(value = "noticeReg.htm", method = RequestMethod.POST)
	public String noticeReg(Notice n, HttpServletRequest request, Principal principal)
	/*public String noticeReg(Notice n, HttpServletRequest request)*/
			throws IOException, ClassNotFoundException, SQLException {
		
		//다중 파일 업로드
		//view 단
		//<input type="file" name="files[0]"
		//<input type="file" name="files[1]"
		//files[0] , files[1]
		//근거 : private List<CommonsMultipartFile> files; (getter , setter)
		System.out.println("다중 파일 업로드 글 등록 처리");
		System.out.println("n : " + n.getTitle());
		System.out.println("n : " + n.getContent());
		System.out.println("n : " + n.getFiles().get(0).getName());
		System.out.println("n : " + n.getFiles().get(1).getName());
		
		 List<CommonsMultipartFile> files = n.getFiles();
		 //System.out.println(files.size());
		 //서버 upload 폴더에 write / DB 에 파일명 insert
		 List<String> filenames = new ArrayList<>(); //파일명만 추출
		 if(files != null && files.size() > 0) {
			 //업로드한 파일이 하나라도 있다면
			 for(CommonsMultipartFile mutifile : files) {
				 String filename = mutifile.getOriginalFilename();
				 String path = request.getServletContext().getRealPath("/customer/upload");
				 String fpath = path + "\\" + filename;
				 System.out.println(filename + " , " + fpath);
				 if(!filename.equals("")) {
					 //서버에 파일 업로드 (write)
					 FileOutputStream fs = new FileOutputStream(fpath);
					 fs.write(mutifile.getBytes());
					 fs.close();
				 }
				 filenames.add(filename);
			 }
		 }
		 //실 DB Insert
		 n.setFileSrc(filenames.get(0)); 
		 n.setFileSrc2(filenames.get(1));
		 
		 ///////////////////////////////////////////////////////////
		 //인증된 사용자 ID 값 가지고 와서 writer처리
		 //로그인 폼(username, password) > submit > security 처리
		 //기존 : session 객체 활용
		 //UserDetails userinfo = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		 /*
		 SecurityContext context = SecurityContextHolder.getContext();
		 Authentication auth = context.getAuthentication();
		 UserDetails userinfo = (UserDetails) auth.getPrincipal();
		 System.out.println(userinfo.getAuthorities()); //권한정보
		 System.out.println(userinfo.getPassword());
		 System.out.println(userinfo.getUsername()); //로그인한 사용자 ID
		 
		 n.setWriter(userinfo.getUsername());
		 */

		 n.setWriter(principal.getName()); //로그인한 사용자 ID
		 
		 
		 ///////////////////////////////////////////////////////////

		//Mybatis
		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		 noticeDao.insert(n);
		 return "redirect:notice.htm";// redirect:
		
		
		
		
		/*
		단일 파일 업로드 사용 코드 
		String filename = n.getFile().getOriginalFilename();
		String path = request.getServletContext().getRealPath("/customer/upload");

		String fpath = path + "\\" + filename;
		FileOutputStream fs = new FileOutputStream(fpath);
		fs.write(n.getFile().getBytes());
		fs.close();

		// 파일명 추가/////////////
		n.setFileSrc(filename);
		///////////////////////
		noticedao.insert(n);

		// return "notice.htm";
		return "redirect:notice.htm";// redirect:
		
		*/
		// 주소창 주소 확인하기
		// return "redirect:notice.htm";
		// http://localhost:8090/SpringMVC_Basic05_WebSite_Annotation/customer/notice.htm
		// F5 , 새로고침 처리 목록페이지 보여주도록 설정

		// location.href
		// response.sendredirect

		// POINT-1***********************************************
		// public String noticeReg(Notice n , HttpServletRequest request)
		// Parameter > Notice n 객체 타입
		// 글쓰기 화면 입력 > 함수(입력한 값)
		// 전제 : <input 태그 name="" 값하고 Notice 객체가 가지는 memberField명 같은 경우

		// POINT-2***********************************************
		// Spring 에서 파일 업로드
		// 웹 서버 upload 폴더 : 파일올리기 (IO)
		// DB : 파일명만 가지면 된다

		// <Form 태그에 속성으로 : enctype="multipart/form-data">
		// 1.의존 lib 추가 (fileupload , io)
		// 2. VO , DTO 쪽에Spring 제공하는
		// CommonsMultipartFile 타입을 갖는 멤버 변수 추가하기 (setter, getter)

		// 3. 전송페이지에서 <form ... enctype="multipart/form-data" 설정
		// -<input type="file" name="file" 파일명 VO 객체 이름 동일 강제사항

		// 4. xml container 에
		// ***CommonsMultipartFile 반드시> id="multipartResolver"***
		// <bean id="multipartResolver"
		// class="org.springframework.web.multipart.commons.CommonsMultipartResolver" >
		// <property name="maxUploadSize" value="10485760"/>
		// </bean>
	}

	// 글삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {

		//Mybatis
		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		noticeDao.delete(seq);
		return "redirect:notice.htm"; // location.href...
	}

	// 글수정하기 (두가치 처리 : 화면(select) , 처리(update)
	// 글수정하기 (수정하기 화면 , 수정처리)
	// url 주소 같고 (GET , POST)
	@RequestMapping(value = "noticeEdit.htm", method = RequestMethod.GET)
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
		// getNotice
		// 결과 model 객체에 담고
		
		//Mybatis
		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		Notice notice = noticeDao.getNotice(seq);
		model.addAttribute("notice", notice);

		//return "noticeEdit.jsp"; // forward
		return "customer.noticeEdit";
	}

	@RequestMapping(value = "noticeEdit.htm", method = RequestMethod.POST)
	public String noticeEdit(Notice n, HttpServletRequest request)
			throws IOException, ClassNotFoundException, SQLException {
		
		/*
		단일 파일 수정
		String filename = n.getFile().getOriginalFilename();
		String path = request.getServletContext().getRealPath("/customer/upload");
		
		String fpath = path + "\\" + filename;
		FileOutputStream fs = new FileOutputStream(fpath);
		fs.write(n.getFile().getBytes());
		fs.close();
		
		//파일명 추가
		n.setFileSrc(filename);
		*/
	List<CommonsMultipartFile> files = n.getFiles();	
	List<String> filenames = new ArrayList<String>();//파일명만 추출	
	
	if(files != null && files.size() > 0){
		//업로드한 파일이 하나라도 있다면
		for(CommonsMultipartFile multifile : files){
			String filename = multifile.getOriginalFilename();
			String path = request.getServletContext().getRealPath("/customer/upload");
			String fpath = path + "\\" + filename;
			System.out.println(filename + "/" + fpath);
			if(!filename.equals("")){
				//서버에 파일 쓰기 작업
				FileOutputStream fs = new FileOutputStream(fpath);
				fs.write(multifile.getBytes());
				fs.close();
			}
			filenames.add(filename);// 실제 DB insert 할 파일명
		}
	}
	//DB작업
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));

		//Mybatis
		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		noticeDao.update(n);
		return "redirect:noticeDetail.htm?seq=" + n.getSeq();
		
		
		
		
		// update
		// fileupload
		/*
		String filename = n.getFile().getOriginalFilename();
		String path = request.getServletContext().getRealPath("/customer/upload");

		String fpath = path + "\\" + filename;
		FileOutputStream fs = new FileOutputStream(fpath);
		fs.write(n.getFile().getBytes());
		fs.close();

		// 파일명 추가/////////////
		n.setFileSrc(filename);
		///////////////////////
		noticedao.update(n);

		return "redirect:noticeDetail.htm?seq=" + n.getSeq();
		*/
		
	}

	@RequestMapping("download.htm")
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		/*
		 * //한글 처리 형식 지정 String sEncoding = new
		 * String(filename.getBytes("euc-kr"),"8859_1");
		 * response.setHeader("Content-Disposition","attachment;filename= " +
		 * sEncoding);
		 * //response.setHeader("Content-Disposition","attachment;filename= " + filename
		 * +";");
		 */
		// 한글 파일명 처리 (Filtter 처리 확인) -> 경우 ...
		// 한글 파일 깨짐 현상 해결하기
		// String fname = new String(f.getBytes("ISO8859_1"),"UTF-8");
		String fname = new String(f.getBytes("euc-kr"), "8859_1");
		System.out.println(fname);
		// 다운로드 기본 설정 (브라우져가 read 하지 않고 ... 다운 )
		// 요청 - 응답 간에 헤더정보에 설정을 강제 다운로드
		// response.setHeader("Content-Disposition", "attachment;filename=" +
		// new String(fname.getBytes(),"ISO8859_1"));
		response.setHeader("Content-Disposition", "attachment;filename=" + fname + ";");
		// 파일명 전송
		// 파일 내용전송
		String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
		System.out.println(fullpath);
		FileInputStream fin = new FileInputStream(fullpath);
		// 출력 도구 얻기 :response.getOutputStream()
		ServletOutputStream sout = response.getOutputStream();
		byte[] buf = new byte[1024]; // 전체를 다읽지 않고 1204byte씩 읽어서
		int size = 0;
		while ((size = fin.read(buf, 0, buf.length)) != -1) // buffer 에 1024byte
		// 담고
		{ // 마지막 남아있는 byte 담고 그다음 없으면 탈출
			sout.write(buf, 0, size); // 1kbyte씩 출력
		}
		fin.close();
		sout.close();
	}
}
