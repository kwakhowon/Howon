package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

/*

controller -> service -> DB 작업(Mybatis) -> service -> controller

service (DB작업)

*/
@Service
public class CustomerService {
	
	private SqlSession sqlsession;
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	//글 목록보기 서비스
	public List<Notice> notices(String pg , String f , String q , Model model) {
		
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

		List<Notice> list=null;
		try {
			NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
			list = noticedao.getNotices(page, field, query);
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}

	//글 상세보기 서비스
	public Notice noticeDetail(String seq) {
		
		Notice notice=null;
		try {
			NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
			notice = noticedao.getNotice(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return notice;
	}
	
	//글쓰기 서비스
	@Transactional
	public String noticeReg(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
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
		
		//noticedao.insert(n); 기존방법
		
		//트랜잭션 적용하기
		//@Transactional 기본 설정은 예외가 발생하면 rollback
		//add contraint ck_member_hit check(point<3);
		try {
			noticedao.insert(n);
			noticedao.insertOfMemberPoint("hong");
			System.out.println("notice : insert , member : update");
		}catch(Exception e) {
			System.out.println("Trans 예외 발생 : " +e.getMessage());
			throw e; //시점 @Transactional 자동 rollback
		}
		
		//만약에 noticedao.insert(n) 결과는 반영된 행의 수 
		//int row = noticedao.insert(n)
		//row 를 return
		
		return "redirect:notice.htm";  //문자열 리턴
	}

	//글 삭제하기
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.delete(seq);
		return "redirect:notice.htm";
	}

	//글 수정하기 (화면 처리)
	public Notice noticeEdit(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		Notice notice = noticedao.getNotice(seq);
		return notice;
	}
	
	//글 수정하기 (처리)
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
	
	//파일 다운로드
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response) throws IOException {
	  
	  String fname = new String(f.getBytes("euc-kr"), "8859_1");
	  response.setHeader("Content-Disposition", "attachment;filename=" + fname + ";");
	  
	  String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
	  System.out.println(fullpath);
	  FileInputStream fin = new FileInputStream(fullpath);
	  
	  ServletOutputStream sout = response.getOutputStream();
	  byte[] buf = new byte[1024]; // 전체를 다읽지 않고 1204byte씩 읽어서
	  int size = 0;
	  while ((size = fin.read(buf, 0, buf.length)) != -1) 
	  { 
	   sout.write(buf, 0, size); 
	  }
	  fin.close();
	  sout.close();
	 }
}


