package com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.getpatient;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

/**
 * the patient inserted into DB
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "patientId",
        "patientName",
        "address",
        "email",
        "phoneNo"
})

@Getter
@Setter
public class GetPatient {

    /**
     * Doctor id.
     */
    @JsonProperty("patientId")
    @JsonPropertyDescription(" The id of the patient")
    private Integer patientId;

    /**
     * Name of the patient.
     */
    @JsonProperty("patientName")
    @JsonPropertyDescription(" Name of the patient.")
    @NotNull
    @Size(min = 10, message = "Invalid name")
    private String patientName;

    /**
     * Address of the patient.
     */
    @JsonProperty("address")
    @JsonPropertyDescription(" Address of the patient.")
    @NotNull
    private String address;

    /**
     * Email of the patient.
     */
    @JsonProperty("email")
    @JsonPropertyDescription(" Email of the patient.")
    @NotNull
    private String email;

    /**
     * The phone number of the patient.
     */
    @JsonProperty("phoneNo")
    @JsonPropertyDescription(" The phone number of the doctor. ")
    @Size(min = 9, max = 13, message = "Phone no should be from 2 and 34 digits maxim")
    @Pattern(regexp = "(\\+40|0)[0-9]{9}")
    private String phoneNo;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @Override
    public String toString() {
        return "GetPatient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
