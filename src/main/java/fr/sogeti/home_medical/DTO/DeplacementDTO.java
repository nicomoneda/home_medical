package fr.sogeti.home_medical.DTO;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeplacementDTO {

    private String infirmierId;
    private String patientId;

    private DeplacementDAO deplacement;
}
