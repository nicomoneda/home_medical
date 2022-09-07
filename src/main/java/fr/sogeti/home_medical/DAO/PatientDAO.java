package fr.sogeti.home_medical.DAO;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("patient")
public class PatientDAO {

    private String nom;
    private String prenom;
    private String dateNaissance;
    private String adresse;
    private String numeroSecuriteSociale;

    // todo :  ajouter l'infirmierDAO
}
