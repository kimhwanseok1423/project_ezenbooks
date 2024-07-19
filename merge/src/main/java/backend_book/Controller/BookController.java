package com.example.demo.backend_book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.backend_book.dto.BookDTO;
import com.example.demo.backend_book.service.BookService;

@CrossOrigin("*")
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	public BookController() {
		System.out.println("BookController");
	}
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	// http://localhost:8090/book/all
	@GetMapping("/book/all")
	public List<BookDTO> getList() throws Exception {
		return bookService.search();
	}

}
