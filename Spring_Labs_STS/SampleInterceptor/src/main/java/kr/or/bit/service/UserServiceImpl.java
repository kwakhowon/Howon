package kr.or.bit.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import kr.or.bit.dao.UserDAO;
import kr.or.bit.dto.LoginDTO;
import kr.or.bit.dto.UserDTO;

@Repository
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO dao;
	
	@Override
	public UserDTO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

}
