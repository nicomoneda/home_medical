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


    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public DeplacementDAO createDeplacement(@RequestBody DeplacementDAO newDeplacement){
        return this.dService.createDeplacement(newDeplacement);
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
