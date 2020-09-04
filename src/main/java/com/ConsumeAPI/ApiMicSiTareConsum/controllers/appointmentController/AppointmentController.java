package com.ConsumeAPI.ApiMicSiTareConsum.controllers.appointmentController;

import com.ConsumeAPI.ApiMicSiTareConsum.errorModel.ErrorResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.addAppointment.AddAppointmentRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.getappointment.GetAppointmentResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.updateAppointment.UpdateAppointmentRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Api(value = " display / create / update / delete ",
        description = "REST API for Appointment")

public interface AppointmentController {

    @ApiOperation(value = "Get Appointment", nickname = "display")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Result matching criteria", response = GetAppointmentResponse.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No entries found", response = GetAppointmentResponse.class),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid request", response = GetAppointmentResponse.class),
            @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED, message = "Method Not Allowed", response = ErrorResponse.class)
    })

   @GetMapping("/rest-displayAppointment")
    ResponseEntity<?> displayAppointment(@RequestParam Optional<Integer> appointmentId,
                                             @RequestParam Optional<LocalDate> appointmentDate);
    @PostMapping(value ="/rest-addAppointment")
    ResponseEntity<?> addAppointmentRest(@RequestBody @Valid AddAppointmentRequest addPatientRequest);

    @PutMapping("/rest-updateAppointment")
    ResponseEntity<?> updateAppointmentRest(@RequestBody @Valid UpdateAppointmentRequest updateAppointmentRequest);

    @DeleteMapping("/rest-deleteAppointment")
    ResponseEntity<?> deleteAppointmentRest(@RequestParam Optional<Integer> appointmentId);
   }
