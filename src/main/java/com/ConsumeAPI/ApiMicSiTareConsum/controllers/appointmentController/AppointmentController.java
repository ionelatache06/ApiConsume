package com.ConsumeAPI.ApiMicSiTareConsum.controllers.appointmentController;

import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.addAppointment.AddAppointmentRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.updateAppointment.UpdateAppointmentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

public interface AppointmentController {
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
