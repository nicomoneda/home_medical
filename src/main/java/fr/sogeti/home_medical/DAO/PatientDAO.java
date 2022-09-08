package fr.sogeti.home_medical.DAO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("patient")
public class PatientDAO {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String adresse;
    private String numeroSecuriteSociale;

    @DBRef
    private InfirmierDAO infirmier;

}
