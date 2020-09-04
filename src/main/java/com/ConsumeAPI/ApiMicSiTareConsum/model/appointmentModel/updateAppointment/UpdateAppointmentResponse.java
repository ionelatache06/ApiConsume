package com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.updateAppointment;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * updateAppointmentRsp
 * <p>
 * response after updating a customer into DB.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "responseDescription"
})

public class UpdateAppointmentResponse {

    /**
     * Description of the status.
     */
    @JsonProperty("responseDescription")
    @JsonPropertyDescription(" Description of the status.")
    private String responseDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Description of the status.
     */
    @JsonProperty("responseDescription")
    public String getResponseDescription() {
        return responseDescription;
    }

    /**
     * Description of the status.
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
        return "UpdateAppointmentResponse{" +
                "responseDescription='" + responseDescription + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}