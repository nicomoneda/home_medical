package fr.sogeti.home_medical.DAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("deplacement")
public class DeplacementDAO {
    @Id
    private String id;
    private int cout;
    private LocalDateTime dateTime;
    private PatientDAO patient;
    private InfirmierDAO infirmier;

}
