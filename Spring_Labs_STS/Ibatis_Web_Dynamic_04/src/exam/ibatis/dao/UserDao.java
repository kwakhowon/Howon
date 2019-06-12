package exam.ibatis.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import exam.ibatis.dto.Emp;
import exam.ibatis.dto.SearchParam;
import exam.ibatis.dto.SearchParamEmp;
import exam.ibatis.util.IBatisUtil;
import com.ibatis.sqlmap.client.SqlMapClient;
public class UserDao {
	// 전체 조건 조회 (부등호 처리)
		public List<Emp> list(SearchParam sp)
		throws ClassNotFoundException, SQLException{
			SqlMapClient client = IBatisUtil.getSqlMapClient();
			//System.out.println(sp.getEname() + " / " + sp.getDeptno());
			return client.queryForList("selectEmp",sp);
		}
		public List<Emp> Emplist() throws ClassNotFoundException, SQLException{
			SearchParamEmp params = new SearchParamEmp();
			params.getEmpnoList().add(7369);
			params.getEmpnoList().add(7902);
			params.getEmpnoList().add(7788);
			System.out.println("SearchParamEmp : " + params);
			SqlMapClient client = IBatisUtil.getSqlMapClient();
			return client.queryForList("selectByEmpno",params);
			//return client.queryForList("EmpList",params);
			//empno in (7369,7902,7788)
		}
		
		/*	
	public void insert(UserDto dto) 
			throws ClassNotFoundException, SQLException{
		SqlMapClient client = IBatisUtil.getSqlMapClient();
		client.insert("insertUser", dto);
	}
	public void update(UserDto dto)
			throws ClassNotFoundException, SQLException{
		SqlMapClient client = IBatisUtil.getSqlMapClient();
		client.update("updateUser", dto);
	}
	public void delete(String userid)
			throws ClassNotFoundException, SQLException{
		SqlMapClient client = IBatisUtil.getSqlMapClient();
		client.delete("deleteUser", userid);
	}
	//select ....
	
	//한건 조회
	public UserDto findById(String userid)
	throws ClassNotFoundException, SQLException{
		SqlMapClient client = IBatisUtil.getSqlMapClient();
		return (UserDto)client.queryForObject("selectAllByUserid",userid);
	}*/
}
