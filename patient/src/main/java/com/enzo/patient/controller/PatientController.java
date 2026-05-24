package com.enzo.patient.controller;

import com.enzo.patient.model.Patient;
import com.enzo.patient.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;


    @PostMapping("/add")
    public Patient addPatient(@RequestBody  Patient patient) {
        return patientService.save(patient);
    }

    @GetMapping("/get/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        patient.setId(id);
        return patientService.update(patient);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Long id) {
         patientService.delete(id);
    }

    @GetMapping("/get")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }
}
