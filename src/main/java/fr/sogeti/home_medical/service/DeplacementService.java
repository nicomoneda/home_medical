package fr.sogeti.home_medical.service;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import fr.sogeti.home_medical.repository.DeplacementRespository;
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

    @Autowired
    DeplacementService(DeplacementRespository deplacementRepo){
        this.deplacementRepo = deplacementRepo;
    }

    public List<DeplacementDAO> getAll() {
        return this.deplacementRepo.findAll();
    }

    public Optional<DeplacementDAO> getById(String id) {
        return this.deplacementRepo.findById(id);
    }

    public DeplacementDAO createDeplacement(DeplacementDAO newDeplacement){
        return this.deplacementRepo.insert(newDeplacement);
    }
    public DeplacementDAO updateDeplacement(String id,DeplacementDAO newDeplacement){
        if (!Objects.equals(id, newDeplacement.getId())) throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return this.deplacementRepo.save(newDeplacement);
    }
    public void deleteDeplacement(String id){
         this.deplacementRepo.deleteById(id);
    }


}
