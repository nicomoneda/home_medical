package fr.sogeti.home_medical.controller;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import fr.sogeti.home_medical.service.DeplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deplacement")
public class DeplacementController {
    private DeplacementService dService;
    @Autowired
    DeplacementController(DeplacementService dService){
        this.dService = dService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<DeplacementDAO> getByPatient(@PathVariable String id) {
        return this.dService.getByPatient(id);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<DeplacementDAO> getByPatientAndInfirmier(@PathVariable String patientNo, String infirmierNo){
        return this.dService.getByPatientAndInfirmier(patientNo,infirmierNo);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public DeplacementDAO addDeplacement(@RequestBody DeplacementDAO newDeplacement){
        return this.dService.addDeplacement(newDeplacement);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public DeplacementDAO updateDeplacement(@RequestBody DeplacementDAO newDeplacement){
        return this.dService.updateDeplacement(newDeplacement);
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDeplacement(@PathVariable String id){
        this.dService.deleteDeplacement(id);
    }


}
