package fr.sogeti.home_medical.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import fr.sogeti.home_medical.DAO.InfirmierDAO;
import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.service.PatientService;

/**
 * class to manage client requests that ask for patients informations
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
    public PatientDAO getPatientByName(@PathVariable String name) {
        return this.service.getPatientByName(name);
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
    public InfirmierDAO updateNurse(@PathVariable String id, @RequestBody InfirmierDAO infirmier) {
        return this.service.updateNurse(id, infirmier);
    }

    /**
     * Afficher les déplacements liés à ce patient
     */
    @GetMapping("/deplacement")
    public List<DeplacementDAO> getDeplacementForThisPatient(@PathVariable String patientId) {
    return this.service.getDeplacementForThisPatient(patientId);
    }


    @PatchMapping("/adddep/{id}")
    public PatientDAO addDeplacement(@RequestBody DeplacementDAO deplacement,@PathVariable String id ){
       return this.service.addDeplacement(deplacement,id);
    }

}
