package com.ezenbooks.backend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.ezenbooks.backend.dto.BookDTO;

@Mapper //bookMapper.xml과 자동으로 연결시켜주는 어노테이션
@Repository //dao 부분을 선언하는 어노테이션 //sqlSessionTemplete 과 같은 설정을 대신해준다.
public interface BookDAO {
	
	public List<BookDTO> getBookList() throws Exception;
	
	public List<BookDTO> getCategoryList(int code) throws Exception;
	
	public List<BookDTO> getNewestList() throws Exception;
	
	public List<BookDTO> getNewestSmallList() throws Exception;
	
	public List<BookDTO> getCategoryNewestList(int code) throws Exception;
	
	/* 여기서 부터 환석님꺼 합친거 */
	
	public List<BookDTO> getSearchList(String book_title) throws Exception;
	
<<<<<<< HEAD
=======

	/* 예림 */
    public void boardInsert(BookDTO bookDTO) throws Exception;
    
    public int insertBookList(BookDTO bookDTO) throws Exception;
	
	public BookDTO content(int book_num);
	
	public void updateBookList(BookDTO bookDTO) throws Exception;
	
	public int delBookList(int book_num) throws Exception;
	
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
}
