package com.enzo.webapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    private Long id;
    private String  firstName;
    private String lastName;
    private LocalDate birthday;
    private String gender;
    private String phone;
    private String email;
}
