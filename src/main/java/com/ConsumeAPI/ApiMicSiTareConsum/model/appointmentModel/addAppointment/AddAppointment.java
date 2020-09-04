package com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.addAppointment;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * the appointment inserted into DB
 *
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "patientName",
        "doctorName",
        "appointmentDate",
        "appointmentTime"
})


public class AddAppointment {


    @JsonProperty("patientName")
    @JsonPropertyDescription(" The patient name ")
    @NotNull
    @Size(min = 3, message = "Invalid name")
    @Pattern(regexp = "[a-zA-Z ]*")
    private String patientName;

    @JsonProperty("doctorName")
    @JsonPropertyDescription(" The doctor name")
    @Size(min = 3, message = "Invalid name")
    @Pattern(regexp = "[a-zA-Z ]*")
    private String doctorName;

    @JsonProperty("appointmentDate")
    @JsonPropertyDescription(" The appointmentDate.")
    @FutureOrPresent
    private LocalDate appointmentDate;

    @JsonProperty("appointmentTime")
    @JsonPropertyDescription(" The appointmentTime.")
    //@FutureOrPresent
    private LocalTime appointmentTime;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return "AddAppointment{" +
                "patientName=" + patientName +
                ", doctorName=" + doctorName +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
