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


    public DeplacementDAO createDeplacement(DeplacementDAO newDeplacement){
        return this.deplacementRepo.insert(newDeplacement);
    }
    public DeplacementDAO updateDeplacement(DeplacementDAO newDeplacement){
        return this.deplacementRepo.save(newDeplacement);
    }
    public void deleteDeplacement(String id){
         this.deplacementRepo.deleteById(id);
    }


}
