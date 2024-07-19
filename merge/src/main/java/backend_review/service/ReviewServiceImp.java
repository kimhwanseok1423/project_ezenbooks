package com.example.demo.backend_review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.backend_review.dao.ReviewDAO;
import com.example.demo.backend_review.dto.ReviewDTO;

@Service
public class ReviewServiceImp implements ReviewService{
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public ReviewServiceImp() {
	
	}
	
	public void setReviewDAO(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	@Override
	public List<ReviewDTO> reviewList(int book_num) throws Exception {
		return reviewDAO.reviewList(book_num);
	}

	@Override
	public int insert(ReviewDTO dto) throws Exception {
		System.out.println("ReviewService");
		return reviewDAO.insertReview(dto);
	}

	@Override
	public int update(ReviewDTO dto) throws Exception {
		return reviewDAO.updateReview(dto);
	}

	@Override
	public int delete(int user_id) throws Exception {
		return reviewDAO.deleteReview(user_id);
	}
}
