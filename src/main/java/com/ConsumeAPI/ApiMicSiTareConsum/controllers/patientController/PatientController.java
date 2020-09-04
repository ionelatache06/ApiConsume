package com.ConsumeAPI.ApiMicSiTareConsum.controllers.patientController;

import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.addPatient.AddPatientRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.updatePatient.UpdatePatientRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

public interface PatientController {

    @GetMapping("/rest-displayPatient")
    public ResponseEntity<?> getPatients(@RequestParam Optional<Integer> patientId,
                                      @RequestParam Optional<String> phoneNumber);

    @PostMapping(value ="/rest-addPatient")
    ResponseEntity<?> addPatientRest(@RequestBody @Valid AddPatientRequest addPatientRequest);

    @PutMapping("/rest-updatePatient")
    ResponseEntity<?> updatePatientRest(@RequestBody @Valid UpdatePatientRequest patientRequest);
}
