package fr.sogeti.home_medical.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.service.PatientService;

/**
 * class to manage client requests about patients informations
 */
@RestController
public class PatientController {

    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    /**
     * method that show all patients
     * @return Table of patients
     */
    @GetMapping("")
    public List<PatientDAO> getAllPatients(){
        return null;
    }

    /**
     * method that show one selected patient
     */
    @GetMapping("/{id}")
    public PatientDAO getPatientById(){
        return null;
    }

    /**
     * method that create a new patient
     */
    public void addPatient(){
        //todo
    }


    /**
     * method that update patient information
     */
    public void updatePatient(){
        //todo
    }


    /**
     * method that remove a patient
     * dont remove patient from DB
     */
    public void diselectPatient(){
        //todo
    }

}
