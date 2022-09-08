package fr.sogeti.home_medical.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import fr.sogeti.home_medical.DAO.InfirmierDAO;
import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.repository.DeplacementRespository;
import fr.sogeti.home_medical.repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository patientRepo;
    private DeplacementRespository deplacementRepo;

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
     * method that found patient by using his name
     * 
     * @param name
     * @return
     */
    public PatientDAO getPatientByName(String name) {
        List<PatientDAO> patients = getAllPatients();
        for (PatientDAO patient : patients) {
            if (patient.getNom().equals(name))
                return patient;
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "aucun resultat");
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
        if (!id.equals(patient.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return this.patientRepo.save(patient);
    }

    /**
     * method that update nurse
     */
    public InfirmierDAO updateNurse(String id, InfirmierDAO infirmier) {
        Optional<PatientDAO> patient = this.patientRepo.findById(id);
        patient.get().setInfirmier(infirmier);
        return infirmier;
    }

    /**
     * Recupérer les déplacements liés à ce patient
     */
    public List<DeplacementDAO> getDeplacementForThisPatient(String patientId) {
       PatientDAO patient  = this.patientRepo.findById(patientId).get();
       return patient.getDeplacement();
    }

    public PatientDAO addDeplacement(DeplacementDAO deplacement, String id ){
        PatientDAO patient  = this.patientRepo.findById(id).get();
        patient.addDeplacement(deplacement);
        this.patientRepo.save(patient);
        return patient;
    }
}
