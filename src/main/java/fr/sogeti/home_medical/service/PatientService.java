package fr.sogeti.home_medical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sogeti.home_medical.repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository patientRepo;

    @Autowired
    public PatientService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }
}
