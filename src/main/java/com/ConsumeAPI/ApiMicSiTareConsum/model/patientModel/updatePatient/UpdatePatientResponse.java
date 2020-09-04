package com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.updatePatient;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * updateCustomerRsp
 * <p>
 * response after updating a customer into DB.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "responseDescription"
})

public class UpdatePatientResponse {

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
        return "UpdatePatientResponse{" +
                "responseDescription='" + responseDescription + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
