package fr.sogeti.home_medical.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("infirmier")
public class InfirmierDAO {
    @Id
    private String id ;
    private String nom ;
    private String prenom ;
    private String numeroProfessionnel ;
    private String telephoneMobile ;
    private String telephoneFixe ;
    @DBRef
    private List<PatientDAO> patients ;

    public void addPatient(PatientDAO patient) {
        this.patients.add(patient);
    }

}
