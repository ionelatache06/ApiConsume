package com.ConsumeAPI.ApiMicSiTareConsum.controllers.doctorController;

import com.ConsumeAPI.ApiMicSiTareConsum.errorModel.ErrorResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel.addDoctor.AddDoctorRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel.getdoctor.GetDoctorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;


@Api(value = "display / create ",
        description = "REST API for Doctor")

public interface DoctorController {

    @ApiOperation(value = "Get Doctor", nickname = "display")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Result matching criteria", response = GetDoctorResponse.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No entries found", response = GetDoctorResponse.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid request", response = GetDoctorResponse.class),
            @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED, message = "Method Not Allowed", response = ErrorResponse.class)
    })

    @GetMapping("/rest-displayDoctor")
    public ResponseEntity<?> displayDoctor(@RequestParam Optional<Integer> doctorId,
                                        @RequestParam Optional<String> doctorName);

    @PostMapping(value ="/rest-addDoctor")
    ResponseEntity<?> addDoctorRest(@RequestBody @Valid AddDoctorRequest addDoctorRequest);
}
