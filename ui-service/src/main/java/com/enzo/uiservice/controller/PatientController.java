package com.enzo.uiservice.controller;



import com.enzo.uiservice.dto.PatientDTO;
import com.enzo.uiservice.service.proxy.PatientFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class PatientController {

    private final PatientFeignClient patientFeignClient;

    @GetMapping("/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientFeignClient.getAllPatients());
        return "listPatients";
    }

    @GetMapping("/patients/add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patientDto", new PatientDTO());
        return "patientForm";
    }

    @PostMapping("/patients/add")
    public String addPatient(@ModelAttribute("patientDto") PatientDTO patientDTO) {
        patientFeignClient.addPatient(patientDTO);
        return "redirect:/patients";
    }

    @GetMapping("/patients/update/{id}")
    public String showUpdatePatientForm(@PathVariable Long id, Model model) {
        model.addAttribute("patientDto", patientFeignClient.getPatientById(id));
        return "patientForm";

    }

    @PostMapping("/patients/update/{id}")
    public String updatePatient(@PathVariable Long id,@ModelAttribute("patientDto") PatientDTO patientDTO) {
        patientFeignClient.updatePatient(id, patientDTO);
        return "redirect:/patients";
    }

    @DeleteMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientFeignClient.deletePatient(id);
        return "redirect:/patients";
    }


}
