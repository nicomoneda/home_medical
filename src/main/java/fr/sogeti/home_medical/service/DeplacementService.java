package fr.sogeti.home_medical.service;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import fr.sogeti.home_medical.DAO.InfirmierDAO;
import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.DTO.DeplacementDTO;
import fr.sogeti.home_medical.repository.DeplacementRespository;
import fr.sogeti.home_medical.repository.InfirmierRespository;
import fr.sogeti.home_medical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DeplacementService {
    private DeplacementRespository deplacementRepo;

    private PatientRepository patientRepo;
    private InfirmierRespository infirmierRepo;

    private InfirmierService infirmierService;

    private PatientService patientService;

    @Autowired
    DeplacementService(DeplacementRespository deplacementRepo, InfirmierService infirmierService, PatientService patientService,PatientRepository patientRepo,InfirmierRespository infirmierRepo ){
        this.deplacementRepo = deplacementRepo;
        this.infirmierService = infirmierService;
        this.patientService = patientService;
        this.patientRepo = patientRepo;
        this.infirmierRepo = infirmierRepo;
    }

    public List<DeplacementDAO> getAll() {
        return this.deplacementRepo.findAll();
    }

    public Optional<DeplacementDAO> getById(String id) {
        return this.deplacementRepo.findById(id);
    }

    public DeplacementDAO createDeplacement(DeplacementDTO newDeplacement){
        DeplacementDAO deplacement = this.deplacementRepo.insert(newDeplacement.getDeplacement());
        String infirmierId = newDeplacement.getInfirmierId();
        String patientId = newDeplacement.getPatientId();

        InfirmierDAO infirmier = this.infirmierService.getById(infirmierId).get();
        PatientDAO patient =  this.patientService.getPatientById(patientId).get();

        patient.addDeplacement(deplacement);
        infirmier.addDeplacement(deplacement);

        this.patientRepo.save(patient);
        this.infirmierRepo.save(infirmier);

        return deplacement;

        //inserer le déplacement à l'infirmier

       // return this.deplacementRepo.insert(newDeplacement);
    }
    public DeplacementDAO updateDeplacement(String id,DeplacementDAO newDeplacement){
        if (!Objects.equals(id, newDeplacement.getId())) throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return this.deplacementRepo.save(newDeplacement);
    }
    public void deleteDeplacement(String id){
         this.deplacementRepo.deleteById(id);
    }


}
