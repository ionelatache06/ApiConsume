package com.ConsumeAPI.ApiMicSiTareConsum.controllers.doctorController;

import com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel.addDoctor.AddDoctorRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel.addDoctor.AddDoctorResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.doctorModel.getdoctor.GetDoctorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class DoctorControllerImpl implements DoctorController {


    @Value("${mvc.basepathDoctor}")
    private String basepathDoctor;

    @Value("${mvc.getEndpoint}")
    private String getEndpoint;

    @Value("${mvc.postEndpoint}")
    private String postEndpoint;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResponseEntity<?> displayDoctor(Optional<Integer> doctorId, Optional<String> doctorName){
        RestTemplate restTemplate = new RestTemplate();
        //case doctorId is preset
        if (doctorId.isPresent() && doctorName.isEmpty()){
            //adding headers
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            //wrap the headers
            HttpEntity httpEntity = new HttpEntity(httpHeaders);

            //call the endpoint
            ResponseEntity<String> responseEntity = restTemplate.exchange(basepathDoctor.concat(getEndpoint).concat("?doctorId={id}"),
                    HttpMethod.GET,
                    httpEntity,
                    String.class,
                    doctorId.get());

            //check if the call returned 200
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                try {
                    //convert responseBody to JSON
//                    String json = objectMapper.writeValueAsString(responseEntity.getBody());
                    //map JSON to our POJO
                    GetDoctorResponse getDoctorResponse = objectMapper.readValue(responseEntity.getBody(), GetDoctorResponse.class);
                    return new ResponseEntity<>(getDoctorResponse, HttpStatus.OK);

                } catch (JsonProcessingException e) {
                    return new ResponseEntity<>("Error processing response as json", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            return  responseEntity;
        }
        return null;
    }

    @Override
    public ResponseEntity<?> addDoctorRest(AddDoctorRequest addDoctorRequest) {
        RestTemplate restTemplate = new RestTemplate();
        {
            //adding headers
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            HashMap<String, String> parameters = new HashMap<>();
            String name = addDoctorRequest.getDoctor().getDoctorName();
            String phoneNo = addDoctorRequest.getDoctor().getPhoneNo();
            String contract  = addDoctorRequest.getDoctor().getContract();
            String medicalSpeciality = addDoctorRequest.getDoctor().getMedicalSpeciality();

            parameters.put("doctorName", name);
            parameters.put("phoneNo", phoneNo);
            parameters.put("contract", contract);
            parameters.put("medicalSpeciality", medicalSpeciality);
            HashMap<String, HashMap<String, String>> doctorObject =  new HashMap<>();
            doctorObject.put("doctor", parameters);

            HttpEntity<?> httpEntity = new HttpEntity<Object>(doctorObject, httpHeaders);

            //call the endpoint
            ResponseEntity<Object> responseEntity = restTemplate.exchange(basepathDoctor.concat(postEndpoint),
                    HttpMethod.POST,
                    httpEntity,
                    Object.class);

            //check if the call returned 200
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                try {
                    //convert responseBody to JSON
                    System.out.println(responseEntity.getBody());
                    String json = objectMapper.writeValueAsString(responseEntity.getBody());
                    //map JSON to our POJO
                    AddDoctorResponse addDoctorResponse = objectMapper.readValue(json, AddDoctorResponse.class);
                    return new ResponseEntity<>(addDoctorResponse, HttpStatus.OK);

                } catch (JsonProcessingException e) {
                    return new ResponseEntity<>("Error processing response as json",
                            HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            return responseEntity;
        }
    }
}




