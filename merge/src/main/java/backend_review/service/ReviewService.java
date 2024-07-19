package com.example.demo.backend_review.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.backend_review.dto.ReviewDTO;

@Service
public interface ReviewService {
	public List<ReviewDTO> reviewList(int book_num) throws Exception;	
	public int insert(ReviewDTO dto) throws Exception;
	public int update(ReviewDTO dto) throws Exception;
	public int delete(int user_id) throws Exception;
}
