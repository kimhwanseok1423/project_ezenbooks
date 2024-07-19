package com.ezenbooks.backend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ezenbooks.backend.dto.ReviewDTO;

/* dto -> reviewDTO로 변경 */

@Mapper
@Repository
public interface ReviewDAO {
	
<<<<<<< HEAD
	public List<ReviewDTO> reviewList(int book_num) throws Exception;

	public int insertReview(ReviewDTO reviewDTO) throws Exception;

	public int updateReview(ReviewDTO reviewDTO) throws Exception;

	public int deleteReview(int user_id) throws Exception;
=======
	public List<ReviewDTO> review() throws Exception;
	
	public List<ReviewDTO> reviewList(int book_num) throws Exception;

	public int insertReview(ReviewDTO dto) throws Exception;

	public void updateReview(ReviewDTO dto) throws Exception;

	public int deleteReview(int review_num) throws Exception;
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
}