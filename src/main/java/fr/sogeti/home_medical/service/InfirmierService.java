package fr.sogeti.home_medical.service;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import fr.sogeti.home_medical.DAO.InfirmierDAO;
import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.repository.InfirmierRespository;
import fr.sogeti.home_medical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InfirmierService {

    private InfirmierRespository repo;
    private PatientService servicePatient ;

    @Autowired
    InfirmierService(InfirmierRespository repo, PatientService servicePatient){
        this.repo = repo ;
        this.servicePatient = servicePatient ;
    }

    /**
     * List all the Infirmiers
     * @return List of infirmiers
     */
    public List<InfirmierDAO> getAll(){
        return this.repo.findAll();
    }

    /**
     * Show an Informier by ID
     * @param id
     * @return an infirmier
     */
    public Optional<InfirmierDAO> getById(String id) {
        return this.repo.findById(id);
    }

    /**
     * Find infirmiers by Firstname
     * @param name
     * @return List of infirmiers with the same FirstName
     */
    public List<InfirmierDAO> getByName(String name) {
        List<InfirmierDAO> infirmiers = this.repo.findAll();
        //infirmiers = infirmiers.stream().filter(item -> item.getNom() == name).toList();
        for (InfirmierDAO infirmier: this.repo.findAll() ) {
            if(!infirmier.getNom().equals(name)) infirmiers.remove(infirmier);
        }
        return infirmiers ;
        //return this.repo.findBy(); ??
    }

    /**
     * Create a new Infirmer
     * @param newInfirmier
     * @return an Infirmier added
     */
    public InfirmierDAO createInfirmier (InfirmierDAO newInfirmier) {
        return this.repo.insert(newInfirmier);
    }

    /**
     * Add a patient to an infirmier's List of patients
     * @param id
     * @param patient
     * @return the updated infirmier
     */
    public InfirmierDAO addPatient(String id, PatientDAO patient) {
        InfirmierDAO infirmier = this.repo.findById(id).get();
        infirmier.addPatient(patient);
        // add infirmier à patient
//        PatientDAO patientUpd = this.servicePatient.getPatientById(patient.getId()).get();
//        this.servicePatient.updateNurse(patient.getId(),infirmier) ;
        return this.repo.save(infirmier);
    }

    /**
     * Remove a patient from an infirmier's List of patients
     * @param id
     * @param patient
     * @return
     */
    public InfirmierDAO removePatient(String id, PatientDAO patient) {
        InfirmierDAO infirmier = this.repo.findById(id).get();
        infirmier.removePatient(patient);
        return this.repo.save(infirmier);
    }

    public String deleteInfirmier(String id) {
        this.repo.deleteById(id);
        return "Infirmier Deleted!";
    }

    /**
     * Delte an Infirmier
     * @param id
     * @return Confirm message
     */
    public List<PatientDAO> listAllMyPatients(String id) {
        List<PatientDAO> patients = this.repo.findById(id).get().getPatients();
        if (patients.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Patients registered with you!");
        return patients ;
    }

    /**
     * Listt all the deplacements of the patiens designated to an infirmier
     * @param id
     * @return List of deplacements
     */
    public List<DeplacementDAO> listAllMyDeplacements(String id){
        List<PatientDAO> patients = this.repo.findById(id).get().getPatients();
        List<DeplacementDAO> deplacements = null ;
        for (PatientDAO patient :patients ) {
            deplacements = new ArrayList<DeplacementDAO>();
            deplacements.addAll(this.servicePatient.getDeplacementForThisPatient(patient.getId()).stream().toList());
        }
        if (deplacements.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Deplacements registered for you!");
        return deplacements ;
    }
}

