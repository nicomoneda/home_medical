package fr.sogeti.home_medical.service;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import fr.sogeti.home_medical.repository.DeplacementRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeplacementService {
    private DeplacementRespository deplacementRepo;

    @Autowired
    DeplacementService(DeplacementRespository deplacementRepo){
        this.deplacementRepo = deplacementRepo;
    }

    public List<DeplacementDAO> getByPatient(String patientId) {
        return this.deplacementRepo.findDeplacementDAOSByPatientNo(patientId);
    }

    public List<DeplacementDAO> getByPatientAndInfirmier(String patientNo, String infirmierNo){
        return this.deplacementRepo.findDeplacementDAOSByPatientNoAndInfirmierNo(patientNo, infirmierNo);
    }

    public DeplacementDAO addDeplacement(DeplacementDAO newDeplacement){
        return this.deplacementRepo.insert(newDeplacement);
    }
    public DeplacementDAO updateDeplacement(DeplacementDAO newDeplacement){
        return this.deplacementRepo.save(newDeplacement);
    }
    public void deleteDeplacement(String id){
         this.deplacementRepo.deleteById(id);
    }


}
