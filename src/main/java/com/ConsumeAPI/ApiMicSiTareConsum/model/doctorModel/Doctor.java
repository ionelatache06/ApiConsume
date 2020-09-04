package com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    private Integer doctorId;

    private String doctorName;

    private String phoneNo;

    private String contract;

    private String medicalSpeciality;

//    public Doctor(Integer doctorId, String doctorName, String phoneNo, String contract, String medicalSpeciality) {
//        this.doctorId = doctorId;
//        this.doctorName = doctorName;
//        this.phoneNo = phoneNo;
//        this.contract = contract;
//        this.medicalSpeciality = medicalSpeciality;
//    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getMedicalSpeciality() {
        return medicalSpeciality;
    }

    public void setMedicalSpeciality(String medicalSpeciality) {
        this.medicalSpeciality = medicalSpeciality;
    }
}
