package com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel.addDoctor;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "doctorId",
        "responseDescription"
})

public class AddDoctorResponse {

    @JsonProperty("doctorId")
    @JsonPropertyDescription(" The id of the new created doctor.")
    private Integer doctorId;
    /**
     * Description of the status.
     *
     */
    @JsonProperty("responseDescription")
    @JsonPropertyDescription(" Description of the status.")
    private String responseDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The id of the new created doctor.
     *
     */
    @JsonProperty("doctorId")
    public Integer getDoctorId() {
        return doctorId;
    }

    /**
     * The id of the new created doctor.
     *
     */
    @JsonProperty("doctorId")
    public void setdoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * Description of the status.
     *
     */
    @JsonProperty("responseDescription")
    public String getResponseDescription() {
        return responseDescription;
    }

    /**
     * Description of the status.
     *
     */
    @JsonProperty("responseDescription")
    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
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
        return "AddDoctorResponse{" +
                "doctorId=" + doctorId +
                ", responseDescription='" + responseDescription + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
