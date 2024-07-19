package com.example.demo.backend_review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.backend_review.dto.ReviewDTO;

@Mapper
@Repository
public interface ReviewDAO {
	
	public List<ReviewDTO> reviewList(int book_num) throws Exception;

	public int insertReview(ReviewDTO dto) throws Exception;

	public int updateReview(ReviewDTO dto) throws Exception;

	public int deleteReview(int usr_id) throws Exception;
}
