package fr.sogeti.home_medical.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("infirmier")
public class InfirmierDAO {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String numeroProfessionnel;
    private String telephoneMobile;
    private String telephoneFixe;
    @DBRef
    @JsonIgnore
    private List<PatientDAO> patients;
    @DBRef
    @JsonIgnore
    private List<DeplacementDAO> deplacements;

    public void addPatient(PatientDAO patient) {
        if(this.patients == null){
            this.patients = new ArrayList<>();
        }
        this.patients.add(patient);
    }

    public void removePatient(PatientDAO patient) {
        if(this.patients != null)
        this.patients.remove(patient);
    }

    public void addDeplacement(DeplacementDAO deplacement){
        if(this.deplacements == null){
            this.deplacements = new ArrayList<>();
        }
        this.deplacements.add(deplacement);
    }

}
