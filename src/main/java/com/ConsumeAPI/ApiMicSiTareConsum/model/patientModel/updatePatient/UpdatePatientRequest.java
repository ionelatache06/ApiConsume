package com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.updatePatient;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * updatePatientReq
 * <p>
 * update a patient structure in DB.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "patient"
})
public class UpdatePatientRequest {

    /**
     * the patient updated into DB
     *
     */
    @JsonProperty("patient")
    @JsonPropertyDescription(" the patient updated into DB")
    @Valid
    private UpdatePatient patient;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * the patient updated into DB
     *
     */
    @JsonProperty("patient")
    public UpdatePatient getPatient() {
        return patient;
    }

    /**
     * the patient updated into DB
     *
     */
    @JsonProperty("patient")
    public void setPatient(UpdatePatient patient) {
        this.patient = patient;
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
        return "UpdatePatientRequest{" +
                "patient=" + patient +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}