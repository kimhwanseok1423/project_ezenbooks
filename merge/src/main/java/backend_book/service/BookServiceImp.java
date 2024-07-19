package com.example.demo.backend_book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.backend_book.dao.BookDAO;
import com.example.demo.backend_book.dto.BookDTO;

@Service
public class BookServiceImp implements BookService {
	
	@Autowired
	private BookDAO bookDAO;

	public BookServiceImp() {

	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public List<BookDTO> search() throws Exception {
		System.out.println("sv:" + bookDAO.getBookList());
		return bookDAO.getBookList();
	}
	

}
