package fr.sogeti.home_medical.repository;

import fr.sogeti.home_medical.DAO.InfirmierDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfirmierRespository extends MongoRepository<InfirmierDAO, String> {
}
