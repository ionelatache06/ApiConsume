package com.ConsumeAPI.ApiMicSiTareConsum.controllers.doctorController;

import com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel.addDoctor.AddDoctorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

public interface DoctorController {

    @GetMapping("/rest-displayDoctor")
    public ResponseEntity<?> displayDoctor(@RequestParam Optional<Integer> doctorId,
                                        @RequestParam Optional<String> doctorName);

    @PostMapping(value ="/rest-addDoctor")
    ResponseEntity<?> addDoctorRest(@RequestBody @Valid AddDoctorRequest addDoctorRequest);
}
