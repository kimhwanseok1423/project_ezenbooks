package com.ezenbooks.backend.service;

import java.util.List;

import com.ezenbooks.backend.dto.BookDTO;

public interface CurationService {
	
	public List<BookDTO> curationProcess(int user_id, int bought);
	
	public List<BookDTO> userPickProcess(int user_id, int bought);
	
<<<<<<< HEAD
=======
	public Integer userIdProcess(String user_name);
	
	public Integer recentPurchaseProcess(Integer user_id);
	
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
}
