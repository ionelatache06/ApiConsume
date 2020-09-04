package com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel.addDoctor;


import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "doctorName",
        "phoneNo",
        "contract",
        "medicalSpeciality"
})
public class AddDoctor {

    /**
     * Name of the doctor.
     */
    @JsonProperty("doctorName")
    @JsonPropertyDescription(" Name of the doctor.")
    @NotNull
    @Size(min = 3, message = "Invalid name")
    @Pattern(regexp = "[a-zA-Z ]*")
    private String doctorName;
    /**
     * The phone number of the doctor.
     */
    @JsonProperty("phoneNo")
    @JsonPropertyDescription(" The phone number of the doctor. ")
    @Size(min = 9, max = 13, message = "Phone no should be from 2 and 34 digits maxim")
    @Pattern(regexp = "(\\+40|0)[0-9]{9}")
    private String phoneNo;

    /**
     * Type of contract.
     */
    @JsonProperty("contract")
    @JsonPropertyDescription(" Type of contract")
    @NotNull
    private String contract;
    /**
     * Medic Speciality.
     */
    @JsonProperty("medicalSpeciality")
    @JsonPropertyDescription("Medical Speciality.")
    @NotNull
    private String medicalSpeciality;



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
        return "AddDoctor{" +
                "doctorName='" + doctorName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
