package com.ezenbooks.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ezenbooks.backend.dto.UserDTO;

@Service
public interface UserService {
	
	public UserDTO userSearch(String username) throws Exception;

	public List<UserDTO> userSearchList() throws Exception;
<<<<<<< HEAD
=======
	
	/* ���� */
	
	public void update(UserDTO userDTO) throws Exception;
	
	public UserDTO updatepro(int user_id);
	
	public int delete(int user_id) throws Exception;

>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42

}
