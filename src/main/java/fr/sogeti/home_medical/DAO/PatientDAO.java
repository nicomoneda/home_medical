package fr.sogeti.home_medical.DAO;

import fr.sogeti.home_medical.DTO.DeplacementDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @DBRef
    private List<DeplacementDAO> deplacement;

    public void addDeplacement(DeplacementDAO deplacement){
        if(this.deplacement == null){
            this.deplacement = new ArrayList<>();
        }
        this.deplacement.add(deplacement);
    }
}
