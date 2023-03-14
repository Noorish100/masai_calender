package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.UserLoginDTO;
import com.Entity.User;
import com.Exception.UserException;
import com.Service.UserImpl;

@RestController
@RequestMapping("/masaicalender")
public class UserController {

	@Autowired
	private UserImpl userServiceImpl;

	@GetMapping("/free")
	public ResponseEntity<String> m() {
		return new ResponseEntity<String>("Free", HttpStatus.OK);
	}

	@GetMapping("/paid")
	public ResponseEntity<String> m2() {
		return new ResponseEntity<String>("Not Free", HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<User> registerUserHandler(@RequestBody User user) throws UserException {

		User registerUser = userServiceImpl.register(user);

		return new ResponseEntity<User>(registerUser, HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUserHandler(@RequestBody UserLoginDTO userDTO) throws UserException {

		String loginUser = userServiceImpl.loginUser(userDTO);

		return new ResponseEntity<String>(loginUser, HttpStatus.OK);

	}

	@PutMapping("/user")
	public ResponseEntity<User> updateUserHandler(@RequestBody User user) throws UserException {

		User updateUser = userServiceImpl.update(user);

		return new ResponseEntity<User>(updateUser, HttpStatus.OK);

	}

}
