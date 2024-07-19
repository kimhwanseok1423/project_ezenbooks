package com.example.demo.backend_review.controller;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.backend_review.dto.ReviewDTO;
import com.example.demo.backend_review.service.ReviewService;
 
@CrossOrigin(origins = { "http://localhost:3000" })

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	public ReviewController() {
		System.out.println("controller");
	}

	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	
	@GetMapping("/review/{book_num}")
	public List<ReviewDTO> reviewList(@PathVariable("book_num") int book_num ) throws Exception {
		return reviewService.reviewList(book_num);
	}
	

	// http://localhost:8090/review
	@PostMapping("/review")
	public ResponseEntity<Object> postTodo(@RequestBody ReviewDTO dto) throws Exception {
		System.out.println("review_controller");
		int chk = reviewService.insert(dto);
		System.out.println("review_controller: " + chk);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		HashMap<String, String> map = new HashMap<>();
		map.put("createDate", new Date().toString());
		map.put("message", "insert ok");

		if (chk >= 1) {
			return new ResponseEntity<Object>(map, header, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/review/{user_id}/{review_content}")
	public void putTodo(@PathVariable("user_id") int user_id, @PathVariable("review_content") String review_content)
			throws Exception {
		System.out.printf("id=%d, completed=%d\n", user_id, review_content);
		ReviewDTO dto = new ReviewDTO();
		dto.setUser_id(user_id);
		dto.setReview_content(review_content);
		reviewService.update(dto);
	}

	// http://localhost:8090/review/1
	@ResponseBody
	@DeleteMapping("/review/{user_id}")
	public void deleteTodo(@PathVariable("user_id") int user_id) throws Exception {
		System.out.printf("id=%d\n", user_id);
		reviewService.delete(user_id);
	}
}
