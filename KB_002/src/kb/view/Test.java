package kb.view;

import kb.dao.EmpDAO;
import kb.dto.EmpDTO;

public class Test {

	public static void main(String[] args) {
		//1. 전체 사원 검색
		System.out.println("1. 전체 사원 검색");
		EmpDAO dao = new EmpDAO();
//		dao.selectAll();
		
		//2. insert
		System.out.println("2. 사원 등록");
		int result = dao.insert(new EmpDTO(6666, "EPT", "CLERK", 1200, null));
		if(result>0) {
			System.out.println(" ---------- success -----------");
		} else {
			System.out.println(" ---------- fail -----------");
		}
		
	}

}
