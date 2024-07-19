package com.ezenbooks.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ezenbooks.backend.repository.UserRepository;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ezenbooks.backend.repository.UserRepository;
import com.ezenbooks.backend.dto.ReviewDTO;
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
import com.ezenbooks.backend.dto.UserDTO;

@CrossOrigin("*")

@RestController
public class IndexController {
	
	@Autowired
	private BCryptPasswordEncoder encodePassWord;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public String join(@RequestBody UserDTO userDTO) {
		
		System.out.println(userDTO.getUser_name());
		System.out.println(userDTO.getUser_pwd());
		System.out.println(userDTO.getUser_email());
		System.out.println(userDTO.getUser_nickname());
		System.out.println(userDTO.getUser_profile());
		System.out.println(userDTO.getUser_role());
		System.out.println(userDTO.getCreate_date());
		userDTO.setUser_pwd(encodePassWord.encode(userDTO.getUser_pwd()));
		userRepository.saveUser(userDTO);
		
		return "회원가입완료";
	}

<<<<<<< HEAD
=======
	// 아이디 중복체크
	@PostMapping("/idChk")
	public int idck(@RequestBody UserDTO userDTO) throws Exception {
		return userRepository.getUserName(userDTO);
	}

	// 닉네임 중복체크
	@PostMapping("/nicknameChk")
	public int nicknameck(@RequestBody UserDTO userDTO) throws Exception {
		// 같은 값이 있을때 유저코드가 같으면 ok
		// 같은 값이 있을때 유저코드가 다르면 수정불가
		int res = userRepository.getUserNick(userDTO);
		// int로 값을 부여 1일 경우 닉네임 중복o, 0일 경우 중복x
		if (res != 0) {
			int same = userRepository.nickUserid(userDTO);
			if (same == 1) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return res;
		}

		
	}

	// 이메일 중복체크
	@PostMapping("/emailChk")
	public int emailck(@RequestBody UserDTO userDTO) throws Exception {
		int res = userRepository.getUserEmail(userDTO);
		if(res!=0) {
			int same = userRepository.emailUserid(userDTO);
			if(same == 1) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return res;
		}
	}

	// http://localhost:8090/review/update
	@PutMapping("/user/update")
	public void updateReview(@RequestBody UserDTO dto) throws Exception {
		dto.setUser_pwd(encodePassWord.encode(dto.getUser_pwd()));
		userRepository.updateUser(dto);
	}

	// http://localhost:8090/review/1
	@ResponseBody
	@PutMapping("/delete/{user_id}")
	public void deleteReview(@PathVariable("user_id") int user_id, @RequestBody UserDTO dto) throws Exception {
		userRepository.deleteUser(dto);
		
	}
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
}
