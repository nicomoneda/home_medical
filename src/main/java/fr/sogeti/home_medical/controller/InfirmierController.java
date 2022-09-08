package fr.sogeti.home_medical.controller;

import fr.sogeti.home_medical.DAO.InfirmierDAO;
import fr.sogeti.home_medical.DAO.PatientDAO;
import fr.sogeti.home_medical.service.InfirmierService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/infirmier")
@CrossOrigin
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

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<InfirmierDAO> getByName(@PathVariable String name) {
        return this.service.getByName(name);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public InfirmierDAO createInfirmier(@RequestBody InfirmierDAO newInfirmier) {
        return this.service.createInfirmier(newInfirmier);
    }

    @PatchMapping("/{id}/add")
    @ResponseStatus(HttpStatus.OK)
    public InfirmierDAO addPatients(@PathVariable String id, @RequestBody PatientDAO patient) {
        return this.service.addPatient(id, patient);
    }

    @PatchMapping("/{id}/remove")
    @ResponseStatus(HttpStatus.OK)
    public InfirmierDAO removePatients(@PathVariable String id, @RequestBody PatientDAO patient) {
        return this.service.removePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteInfirmier(@PathVariable String id){
        return this.service.deleteInfirmier(id);
    }
}
