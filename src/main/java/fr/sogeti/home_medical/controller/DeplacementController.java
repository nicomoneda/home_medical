package fr.sogeti.home_medical.controller;

import fr.sogeti.home_medical.DAO.DeplacementDAO;
import fr.sogeti.home_medical.service.DeplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deplacements")
public class DeplacementController {
    private DeplacementService dService;
    @Autowired
    DeplacementController(DeplacementService dService){
        this.dService = dService;
    }
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<DeplacementDAO> getAll() {
        return this.dService.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DeplacementDAO> getById(@PathVariable String id) {
        return this.dService.getById(id);
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public DeplacementDAO createDeplacement(@RequestBody DeplacementDAO newDeplacement){
        return this.dService.createDeplacement(newDeplacement);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeplacementDAO updateDeplacement(@PathVariable String id, @RequestBody DeplacementDAO newDeplacement){
        return this.dService.updateDeplacement(id,newDeplacement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDeplacement(@PathVariable String id){
        this.dService.deleteDeplacement(id);
    }


}
