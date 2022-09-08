package fr.sogeti.home_medical.service;

import fr.sogeti.home_medical.DAO.InfirmierDAO;
import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.repository.InfirmierRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfirmierService {

    private InfirmierRespository repo;

    @Autowired
    InfirmierService(InfirmierRespository repo){
        this.repo = repo ;
    }

    public List<InfirmierDAO> getAll(){
        return this.repo.findAll();
    }

    public Optional<InfirmierDAO> getById(String id) {
        return this.repo.findById(id);
    }

    public List<InfirmierDAO> getByName(String name) {
        List<InfirmierDAO> infirmiers = this.repo.findAll();
        infirmiers = infirmiers.stream().filter(item -> item.getNom() == name).toList();
        return infirmiers ;
        //return this.repo.findBy();
    }

    public InfirmierDAO createInfirmier (InfirmierDAO newInfirmier) {
        return this.repo.insert(newInfirmier);
    }

    public InfirmierDAO addPatient(String id, PatientDAO patient) {
        InfirmierDAO infirmier = this.repo.findById(id).get();
        infirmier.addPatient(patient);
        return this.repo.save(infirmier);
    }

    public InfirmierDAO removePatient(String id, PatientDAO patient) {
        InfirmierDAO infirmier = this.repo.findById(id).get();
        infirmier.removePatient(patient);
        return this.repo.save(infirmier);
    }

    public String deleteInfirmier(String id) {
        this.repo.deleteById(id);
        return "Infirmier Deleted!";
    }
}

