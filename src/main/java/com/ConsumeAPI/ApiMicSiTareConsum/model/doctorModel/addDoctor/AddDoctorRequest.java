package com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel.addDoctor;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "doctor"
})

public class AddDoctorRequest {


    @JsonProperty("doctor")
    @JsonPropertyDescription(" the doctor inserted into DB")
    @Valid
    private AddDoctor doctor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * the doctor inserted into DB
     *
     */
    @JsonProperty("doctor")
    public AddDoctor getDoctor() {
        return doctor;
    }

    /**
     * the doctor inserted into DB
     *
     */
    @JsonProperty("doctor")
    public void setDoctor(AddDoctor doctor) {
        this.doctor = doctor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
