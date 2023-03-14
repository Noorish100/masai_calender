package com.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	
	@Email(message ="Enter Email in correct format.")
	@Column(unique = true)
	private String emailId;
	
	@NotNull(message = "FirstName should not null")
    @Pattern(regexp = "^[a-zA-Z]*$")
	private String firstName;
	
	@NotNull(message = "not null")
    @Pattern(regexp = "^[a-zA-Z]*$")
	private String lastName;
    
    @Size(min = 10,max = 10,message = "Mobile number should contain 10 digits.")
	private String mobileNumber;
    
    @Past(message = "Date input is invalid for a birth date.")
    private LocalDate dateOfBirth;
    
    @JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
    private List<Event> event;

}
