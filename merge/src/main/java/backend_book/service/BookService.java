package com.example.demo.backend_book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.backend_book.dto.BookDTO;

@Service
public interface BookService {
	public List<BookDTO> search() throws Exception;
}
