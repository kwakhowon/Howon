package kr.or.bit.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.bit.dto.User;

public class program {
	public static void main(String[] args) {
		//method scope
		SqlSessionFactory sqlsession = SqlMapClient.getSqlSession();
		
		SqlSession session = sqlsession.openSession();
		User user = (User)session.selectOne("Emp.getone", "ALLEN");
		System.out.println(user.getEname() + " / " +user.getEmpno());
		session.close();
	}
}
