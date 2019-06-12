package kr.or.bit.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.bit.dto.LoginDTO;
import kr.or.bit.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "kr.or.bit.mapper.UserMapper";
	
	@Override
	public UserDTO login(LoginDTO dto) throws Exception {
		return (UserDTO) session.selectOne(namespace+".login", dto);
	}

}
