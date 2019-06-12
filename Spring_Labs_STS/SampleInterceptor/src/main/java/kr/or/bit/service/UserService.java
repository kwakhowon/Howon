package kr.or.bit.service;

import kr.or.bit.dto.LoginDTO;
import kr.or.bit.dto.UserDTO;

public interface UserService {
	public UserDTO login(LoginDTO dto) throws Exception;
}
