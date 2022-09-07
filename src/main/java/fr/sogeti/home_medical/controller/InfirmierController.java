package fr.sogeti.home_medical.controller;

import fr.sogeti.home_medical.DAO.InfirmierDAO;
import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.service.InfirmierService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/infirmier")
public class InfirmierController {

    private InfirmierService service;

    InfirmierController(InfirmierService service){
        this.service = service ;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<InfirmierDAO> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<InfirmierDAO> getById(@PathVariable String id) {
        return this.service.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public InfirmierDAO createInfirmier(@RequestBody InfirmierDAO newInfirmier) {
        return this.service.createInfirmier(newInfirmier);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InfirmierDAO updatePatients(@PathVariable String id, @RequestBody PatientDAO patient) {
        return this.service.addPatient(id, patient);
    }

}
