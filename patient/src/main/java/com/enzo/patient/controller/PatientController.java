package com.enzo.patient.controller;

import com.enzo.patient.model.Patient;
import com.enzo.patient.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;


    @PostMapping("/add")
    public Patient addPatient(@RequestBody  Patient patient) {
        return patientService.save(patient);
    }
}
