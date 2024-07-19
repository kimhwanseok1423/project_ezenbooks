package com.example.demo.backend_book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.backend_book.dto.BookDTO;

@Mapper
@Repository
public interface BookDAO {
	public List<BookDTO> getBookList() throws Exception;
}
