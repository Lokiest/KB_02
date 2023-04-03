package jdbc.dao;

import java.util.List;

import jdbc.dto.UserDto;

public interface UserDAO {
	
	/**
	 * 고객 등록
	 * 
	 * */
    int insert(UserDto userDto);
	
    
    /**
     * 고객 수정
     * */
	int update(UserDto userDto) ;
	
	/**
	 *  고객 전체 조회
	 * */
	List<UserDto>  selectAll() ;
	
	
	/**
	 * 고객 userSeq에 해당하는 정보 조회
	 * */
	UserDto selectOne(int userSeq) ;
	
	/**
	 * 고객 삭제
	 * */
	int  delete(int userSeq);
	
}
