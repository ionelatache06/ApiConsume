package com.ConsumeAPI.ApiMicSiTareConsum.controllers.patientController;

import com.ConsumeAPI.ApiMicSiTareConsum.errorModel.ErrorResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.addPatient.AddPatientRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.getpatient.GetPatientResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.updatePatient.UpdatePatientRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@Api(value = "display / create / update",
        description = "REST API for Patient")

public interface PatientController {

    @ApiOperation(value = "Get Customer", nickname = "getCustomer")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Result matching criteria", response = GetPatientResponse.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No entries found", response = GetPatientResponse.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid request", response = GetPatientResponse.class),
            @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED, message = "Method Not Allowed", response = ErrorResponse.class)
    })

    @GetMapping("/rest-displayPatient")
    public ResponseEntity<?> getPatients(@RequestParam Optional<Integer> patientId,
                                      @RequestParam Optional<String> phoneNumber);

    @PostMapping(value ="/rest-addPatient")
    ResponseEntity<?> addPatientRest(@RequestBody @Valid AddPatientRequest addPatientRequest);

    @PutMapping("/rest-updatePatient")
    ResponseEntity<?> updatePatientRest(@RequestBody @Valid UpdatePatientRequest patientRequest);
}
