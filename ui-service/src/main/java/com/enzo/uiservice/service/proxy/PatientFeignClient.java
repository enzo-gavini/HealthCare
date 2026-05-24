package com.enzo.uiservice.service.proxy;


import com.enzo.uiservice.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="patient", contextId = "patientClient")
public interface PatientFeignClient {

    @PostMapping("/add")
    public PatientDTO addPatient(@RequestBody PatientDTO patientDTO);

    @GetMapping("/get/{id}")
    public PatientDTO getPatientById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    public PatientDTO updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO);

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Long id);

    @GetMapping("/get")
    public List<PatientDTO> getAllPatients();
}
