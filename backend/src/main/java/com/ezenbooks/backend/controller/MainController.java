package com.ezenbooks.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezenbooks.backend.controller.MainController;
import com.ezenbooks.backend.dto.BestsellerDTO;
import com.ezenbooks.backend.dto.BookDTO;
import com.ezenbooks.backend.service.BestsellerService;
import com.ezenbooks.backend.service.CurationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

//@RestController = @Controller + @ResponseBody
@CrossOrigin("*") //포트번호에 관계없이 응답을 허가해주는 어노테이션
//@RestController = @Controller + @ResponseBody

//http://localhost:8090/index
@RequestMapping("/index")
@RestController
@RequiredArgsConstructor
@Log4j2
public class MainController {
	
	private final CurationService curationService;
	
	private final BestsellerService bestsellerService;
	
	/**
	 * 주문 기록 기반 추천
<<<<<<< HEAD
	 * 접속중인 유저 ID와 최근 본 책의 번호를 받아 추천 리스트를 반환한다.
=======
	 * 접속중인 유저 ID와 최근 구매한 책의 번호를 받아 추천 리스트를 반환한다.
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
	 * 
	 * @author 김요한
	 * @param user_id
	 * @param bought
	 * @return List<BookDTO>
	 */
<<<<<<< HEAD
	@GetMapping({"/curation/{user_id}/{bought}", "/curation"})
	public ResponseEntity<List<BookDTO>> curation(@PathVariable(required = false) Integer user_id, 
												  @PathVariable(required = false) Integer bought) {
				
		log.info("user_id: " + user_id);
		
		if (ObjectUtils.isEmpty(bought) || ObjectUtils.isEmpty(bought)) {
			user_id = 1;
			bought = 1;
		}
=======
	@GetMapping("/curation")
	public ResponseEntity<List<BookDTO>> curation(@RequestParam(required = false) String user_name, 
												  @RequestParam(required = false) Integer bought) {
				
		log.info("user_name: " + user_name);
		log.info("bought: " + bought);
		
		Integer user_id = curationService.userIdProcess(user_name);
		
		if (ObjectUtils.isEmpty(bought)) {
			bought = 1;
		}
		if(ObjectUtils.isEmpty(user_id)) {
			user_id = 1;
		}
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
		
		List<BookDTO> list = curationService.curationProcess(user_id, bought);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	/**
	 * 평점 기반 추천
	 * 접속중인 유저 ID와 최근 본 책의 번호를 받아 추천 리스트를 반환한다.
	 * 
	 * @author 김요한
	 * @param user_id
	 * @param bought
	 * @return List<BookDTO>
	 */
<<<<<<< HEAD
	@GetMapping({"/userPick/{user_id}/{bought}", "/userPick"})
	public ResponseEntity<List<BookDTO>> userPick(@PathVariable(required = false) Integer user_id, 
			 									  @PathVariable(required = false) Integer bought) {
		
		// 로그인이 안된 사용자 이거나, 내역이 없는 사용자인 경우
		log.info("user_id: " + user_id);
		
		if (ObjectUtils.isEmpty(bought) || ObjectUtils.isEmpty(bought)) {
=======
	@GetMapping("/userPick")
	public ResponseEntity<List<BookDTO>> userPick(@RequestParam(required = false) String user_name) {
				
		Integer user_id = curationService.userIdProcess(user_name);
		Integer bought = curationService.recentPurchaseProcess(user_id);
		
		log.info("user_name: " + user_name);
		log.info("bought: " + bought);
		
		// 로그인이 안된 사용자 이거나, 내역이 없는 사용자인 경우
		if (ObjectUtils.isEmpty(user_name) || ObjectUtils.isEmpty(bought)) {
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
			user_id = 1;
			bought = 1;
		}
		
		List<BookDTO> list = curationService.userPickProcess(user_id, bought);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	/**
	 * 카테고리 번호, 시작 날짜, 끝나는 날짜를 받아 
	 * 베스트셀러 책 리스트를 반환 합니다. 
	 * 
	 * @author 김요한
	 * @param category_code
	 * @param start_date
	 * @param end_date
	 * @return List<BookDTO>
	 */
	@GetMapping("/bestseller")
	public ResponseEntity<List<BookDTO>> bestseller(
			@RequestParam(value = "category_code", required = false, defaultValue = "0") Integer category_code) {
		 
<<<<<<< HEAD
		log.info("bestseller.............");
=======
//		log.info("bestseller.............");
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
		
		BestsellerDTO bestsellerDTO = BestsellerDTO.builder()
				.category_code(category_code)
				.build();
		
		if(ObjectUtils.isEmpty(category_code)) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.BAD_REQUEST);
		}
		
		List<BookDTO> result = bestsellerService.bestsellerProcess(bestsellerDTO);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**
	 * 카테고리 번호를 받아 신간 리스트를 반환 합니다.
	 * 
	 * @author 김요한
	 * @param category_code
	 * @return List<BookDTO>
	 */
	@GetMapping("/newbooks")
	public ResponseEntity<List<BookDTO>> newbooks(
			@RequestParam(value = "category_code", required = false, defaultValue = "0") Integer category_code) {
		
		log.info("new books................");
		
		if(ObjectUtils.isEmpty(category_code)) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.BAD_REQUEST);
		}
		
		List<BookDTO> result = bestsellerService.newBooksListProcess(category_code);
		
		return new ResponseEntity<List<BookDTO>>(result, HttpStatus.OK);
	}

}
