package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {

    @NotBlank(message = "Username is required!!!")
    @Size(min = 3, message = "Username must have minimum 3 characters!!!")
    private String name;

    @Email(message = "Invalid Email Address!!!")
    @NotBlank(message = "Email is required!!!")
    private String email;

    @NotBlank(message = "Password is required!!!")
    @Size(min = 6, message = "Password must have minimum 6 characters!!!")
    private String password;

    @NotBlank(message = "About is rquired")
    private String about;

    @Size(min = 8, max = 12, message = "Invalid Phone Number")
    private String phoneNumber;
}
