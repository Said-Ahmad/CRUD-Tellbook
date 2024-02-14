package com.example.crudtellbook.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String dateOfBirth;
    private String phoneNumber;
    private String SecondPhoneNumber;
    private LocalDateTime dateCreate;

}
