package dao;

import java.sql.SQLException;

import dto.TestUser;

public interface TestUserDao {
	public TestUser check(String id, String password);
	public int insertUser(TestUser user);
}
