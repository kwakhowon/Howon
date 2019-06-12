package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {
	public List<Emp> selectAll();
	public int insert();
	public int delete();
	public int update();
}
