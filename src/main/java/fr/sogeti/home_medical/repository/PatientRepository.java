package fr.sogeti.home_medical.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.sogeti.home_medical.DAO.PatientDAO;

@Repository
public interface PatientRepository extends MongoRepository<PatientDAO , String> {
    
}
