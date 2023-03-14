package com.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.UserLoginDTO;
import com.Entity.User;
import com.Exception.UserException;
import com.Repository.UserDao;

@Service
public class UserImpl implements UserServices {
	
	@Autowired
	private UserDao dao;

	@Override
	public User register(User user)throws UserException {
		if(user==null) {
			throw new UserException("invalid user");
		}
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	@Override
	public User update(User user) throws UserException {
		Optional<User> opt=dao.findById(user.getUser_id());
		if(opt.isPresent()) {
			return dao.save(user);
		}
		else throw new UserException("user not exist");
	}

	@Override
	public String loginUser(UserLoginDTO userDto) throws UserException {
		User user = dao.findByEmailId(userDto.getEmail());
		if(user == null) {
			throw new UserException("Incorrect Email");
		}		
		return "Sucessfully loggedIn";
	}

}
