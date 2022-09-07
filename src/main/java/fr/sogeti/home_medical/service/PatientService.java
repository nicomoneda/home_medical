package fr.sogeti.home_medical.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sogeti.home_medical.DAO.InfirmierDAO;
import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository patientRepo;

    @Autowired
    public PatientService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    /**
     * method that ask recover of all patients
     * 
     * @return Table of patients
     */
    public List<PatientDAO> getAllPatients() {
        return this.patientRepo.findAll();
    }

    /**
     * method that show one selected patient
     */
    public Optional<PatientDAO> getPatientById(String id) {
        return this.patientRepo.findById(id);
    }

    /**
     * method that create a new patient
     */
    public PatientDAO createPatient(PatientDAO patient) {
        return this.patientRepo.insert(patient);
    }

    /**
     * method that update patient information
     */
    public PatientDAO updatePatient(String id, PatientDAO patient) {
        return this.patientRepo.save(patient);

    }

    /**
     * method that update nurse
     */
    public InfirmierDAO updateNurse(String id, InfirmierDAO infirmier){
        Optional<PatientDAO> patient = this.patientRepo.findById(id);
        if(patient != null){
            patient.get().setInfirmier(infirmier);
        }
        return infirmier;
    }

}
