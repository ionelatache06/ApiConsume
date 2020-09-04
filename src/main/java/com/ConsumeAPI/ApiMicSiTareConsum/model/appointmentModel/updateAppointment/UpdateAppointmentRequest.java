package com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.updateAppointment;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "appointment"
})
public class UpdateAppointmentRequest {


    @JsonProperty("appointment")
    @JsonPropertyDescription(" the appointment updated into DB")
    @Valid
    private UpdateAppointment appointment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("appointment")
    public UpdateAppointment getAppointment() {
        return appointment;
    }


    @JsonProperty("appointment")

    public void setAppointment(UpdateAppointment appointment) {
        this.appointment = appointment;
    }

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
        return "UpdateAppointmentRequest{" +
                "appointment=" + appointment +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
