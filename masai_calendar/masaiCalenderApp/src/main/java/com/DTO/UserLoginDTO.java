package com.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserLoginDTO {

	@NotNull(message = "Email should not be null")
	private String email;
	
	@NotNull(message="password should not be null")
	private String password;
}
