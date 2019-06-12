package exam.ibatis.util;

import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.common.resources.Resources;

import java.io.Reader;
import java.util.List;
import java.sql.SQLException;
import java.io.IOException;

public class IBatisUtil {
	private static SqlMapClient sqlMapper;
	
	static{
		try{
			Reader reader = Resources.getResourceAsReader("exam/ibatis/sqlmap/SqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	public static SqlMapClient getSqlMapClient(){
		return sqlMapper;
	}
}
