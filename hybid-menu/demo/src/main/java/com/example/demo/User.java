package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @NotNull // Validation API is required! Add it as a dependency in your project
    private Long id;

    @NotNull
    private String name;

    private Date birthDate;

    @Email
    private String email;

    @NotNull
    private String password;

}
