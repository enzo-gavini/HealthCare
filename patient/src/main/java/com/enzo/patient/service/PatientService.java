package com.enzo.patient.service;

import com.enzo.patient.model.Patient;
import com.enzo.patient.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> findALL() {
        return patientRepository.findAll();
    }

    public Patient update(Patient newPatientData) {
        return patientRepository.save(newPatientData);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email).orElse(null);
    }
}
