package fr.sogeti.home_medical.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.sogeti.home_medical.DAO.InfirmierDAO;
import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.service.PatientService;

/**
 * class to manage client requests about patients informations
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    /**
     * method that show all patients
     * 
     * @return Table of patients
     */
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PatientDAO> getAllPatients() {
        return this.service.getAllPatients();
    }

    /**
     * method that show one selected patient
     * resquest done by patient id
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PatientDAO> getPatientById(@PathVariable String id) {
        return this.service.getPatientById(id);
    }

    /**
     * method that show one selected patient
     * resquest done by patient name
     */
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PatientDAO> getPatientByName(@PathVariable String name) {
        String patientId = null;
        List<PatientDAO> patients = getAllPatients();
        for (PatientDAO patient : patients) {
            if (patient.getNom() == name) {
                patientId = patient.getId();
            }
        }
        return this.service.getPatientById(patientId);
    }

    /**
     * method that create a new patient
     * 
     * @return new patient added
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public PatientDAO createPatient(@RequestBody PatientDAO patient) {
        return this.service.createPatient(patient);
    }

    /**
     * method that update patient information
     */
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PatientDAO updatePatient(@PathVariable String id, @RequestBody PatientDAO patient) {
        this.service.updatePatient(id, patient);
        return patient;
    }

    /**
     * method that update nurse
     */
    @PutMapping("/{id}/nurse")
    public InfirmierDAO updateNurse(@PathVariable String id, @RequestBody InfirmierDAO infirmier){
    return this.service.updateNurse(id,infirmier); 
    }

}
