package fr.sogeti.home_medical.repository;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeplacementRespository extends MongoRepository<DeplacementDAO,String> {

    List<DeplacementDAO> findDeplacementDAOSByPatientNo(String patientNo);
    List<DeplacementDAO> findDeplacementDAOSByPatientNoAndInfirmierNo(String patientNo,String infirmierNo);

}
