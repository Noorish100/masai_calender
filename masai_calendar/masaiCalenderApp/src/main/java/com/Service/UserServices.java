package com.Service;

import com.DTO.UserLoginDTO;
import com.Entity.User;
import com.Exception.UserException;

public interface UserServices {
	
  public User register(User user) throws UserException;
	
	public User update(User user)throws UserException;
	public String loginUser(UserLoginDTO userDto) throws UserException;
}
