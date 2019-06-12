package exam.ibatis.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchParamEmp {
	private List<Integer> empnolist = new ArrayList<Integer>();
	public List<Integer> getEmpnoList(){
		return empnolist;
	}
}
