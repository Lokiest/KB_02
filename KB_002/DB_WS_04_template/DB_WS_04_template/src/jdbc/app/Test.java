package jdbc.app;

import java.util.List;

import jdbc.dao.UserDAO;
import jdbc.dao.UserDAOimpl;
import jdbc.dto.UserDto;

public class Test {

	public static void main(String[] args) {
		
       
		// #1. users table 에 insert 1건 처리를 위해 insert() 를 완성한다.
//		insert();
//		// #2. users table 에 update 1건 처리를 위해 update() 를 완성한다.
//		update();
		// #3. users table 을 전체 조회, 출력하는 selectAll() 를 완성한다.
		selectAll();
		// #4. users table 을 user_seq 로 1건  조회, 출력하는 selectOne() 를 완성한다.
//		selectOne();
//		// #5. users table 을 user_seq 로 1건  삭제하는 delete() 를 완성한다.
//		delete();
		
	}
	
	static void insert() {
		UserDto userDto = new UserDto();
		userDto.setUserSeq(666);
		userDto.setName("육길동");
		userDto.setEmail("six@gildong@com");
		userDto.setPhone("010-6666-6666");
		userDto.setSleep(false);
		
		//  dao호출하고 그결과에 따라 출력한다.
		UserDAO dao = new UserDAOimpl();
		int result = dao.insert(userDto);
		if (result>0) {
			System.out.println("--------success");
		} else {
			System.out.println(" --------fail");
		}
		
	}
	
	static void update() {
		UserDto userDto = new UserDto();
		userDto.setUserSeq(666);
		userDto.setName("육길동");
		userDto.setEmail("yook@gildong@com");
		userDto.setPhone("010-7777-7777");
		userDto.setSleep(true);

	//  dao호출하고 그결과에 따라 출력한다.
		UserDAO dao = new UserDAOimpl();
		int result = dao.update(userDto);
		if (result>0) {
			System.out.println(" --------success");
		} else {
			System.out.println(" --------fail");
		}
	}
	
	static void selectAll() {
		UserDAO dao = new UserDAOimpl();
		List<UserDto> users = dao.selectAll();
		for(UserDto user : users) {
			System.out.println(user);
		}
		//  dao호출하고 그결과에 따라 출력한다.
		
	}
	
	static void selectOne() {
		int userSeq = 666;
		UserDAO dao = new UserDAOimpl();
		dao.selectOne(userSeq);
	//  dao호출하고 그결과에 따라 출력한다.
		
		
	}
	
	static void delete() {	
		int userSeq = 666;
		UserDAO dao = new UserDAOimpl();
		int result = dao.delete(userSeq);
		if (result>0) {
			System.out.println(" --------success");
		} else {
			System.out.println(" --------fail");
		}
	}
}


