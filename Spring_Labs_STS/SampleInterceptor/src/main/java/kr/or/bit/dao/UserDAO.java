package kr.or.bit.dao;

import kr.or.bit.dto.LoginDTO;
import kr.or.bit.dto.UserDTO;

public interface UserDAO {
	public UserDTO login(LoginDTO dto) throws Exception;
}
