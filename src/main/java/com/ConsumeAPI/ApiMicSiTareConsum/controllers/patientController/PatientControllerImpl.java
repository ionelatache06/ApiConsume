package com.ConsumeAPI.ApiMicSiTareConsum.controllers.patientController;

import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.addPatient.AddPatientRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.addPatient.AddPatientResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.getpatient.GetPatientResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.updatePatient.UpdatePatientRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.updatePatient.UpdatePatientResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class PatientControllerImpl implements PatientController {

    @Value("${mvc.basepathPatient}")
    private String basepathPatient;

    @Value("${mvc.getEndpoint}")
    private String getEndpoint;

    @Value("${mvc.postEndpoint}")
    private String postEndpoint;

    @Value("${mvc.putEndpoint}")
    private String putEndpoint;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResponseEntity<?> getPatients(Optional<Integer> patientId, Optional<String> phoneNumber){
        RestTemplate restTemplate = new RestTemplate();
        //case patientId is preset
        if (patientId.isPresent() && phoneNumber.isEmpty()){
            //adding headers
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            //wrap the headers
            HttpEntity httpEntity = new HttpEntity(httpHeaders);

            //call the endpoint
            ResponseEntity<String> responseEntity = restTemplate.exchange(basepathPatient.concat(getEndpoint).concat("?patientId={id}"),
                    HttpMethod.GET,
                    httpEntity,
                    String.class,
                    patientId.get());

            //check if the call returned 200
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                try {
                    //convert responseBody to JSON
//                    String json = objectMapper.writeValueAsString(responseEntity.getBody());
                    //map JSON to our POJO
                    GetPatientResponse getPatientResponse = objectMapper.readValue(responseEntity.getBody(), GetPatientResponse.class);
                    return new ResponseEntity<>(getPatientResponse, HttpStatus.OK);

                } catch (JsonProcessingException e) {
                    return new ResponseEntity<>("Error processing response as json", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            return  responseEntity;
        }
        return null;
    }

    /*@Override
    public ResponseEntity<?> addPatientRest(AddPatientRequest addPatientRequest) {

    RestTemplate restTemplate = new RestTemplate();
    {
        //adding headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        //Construct hashmap with parameters
        HashMap<String, String> parameters = new HashMap<>();
        String name = addPatientRequest.getPatient().getPatientName();
        String address  = addPatientRequest.getPatient().getAddress();
        String email = addPatientRequest.getPatient().getEmail();
        String phoneNo = addPatientRequest.getPatient().getPhoneNo();
        parameters.put("patientName", name);
        parameters.put("address", address);
        parameters.put("email", email);
        parameters.put("phoneNo", phoneNo);
        HashMap<String, HashMap<String, String>> patientObject =  new HashMap<>();
        patientObject.put("patient", parameters);

        HttpEntity<?> httpEntity = new HttpEntity<Object>(patientObject, httpHeaders);

        //call the endpoint
        ResponseEntity<Object> responseEntity = restTemplate.exchange(basepathPatient.concat(postEndpoint),
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
                AddPatientResponse addPatientResponse = objectMapper.readValue(json, AddPatientResponse.class);
                return new ResponseEntity<>(addPatientResponse, HttpStatus.OK);

            } catch (JsonProcessingException e) {
                return new ResponseEntity<>("Error processing response as json",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return responseEntity;
    }
}*/

    @Override
    public ResponseEntity<?> addPatientRest(@RequestBody AddPatientRequest addPatientRequest) {
        RestTemplate restTemplate = new RestTemplate();
            //adding headers
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> httpEntity = new HttpEntity<Object>(addPatientRequest, httpHeaders);

            //call the endpoint
            ResponseEntity<Object> responseEntity = restTemplate.exchange(basepathPatient.concat(postEndpoint),
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
                    AddPatientResponse addPatientResponse = objectMapper.readValue(json, AddPatientResponse.class);
                    return new ResponseEntity<>(addPatientResponse, HttpStatus.OK);

                } catch (JsonProcessingException e) {
                    return new ResponseEntity<>("Error processing response as json",
                            HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            return responseEntity;
        }

    @Override
    public ResponseEntity<?> updatePatientRest(UpdatePatientRequest updatePatientRequest) {

        RestTemplate restTemplate = new RestTemplate();
        {
            //adding headers
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            HashMap<String, String> parameters = new HashMap<>();
            String patientId = updatePatientRequest.getPatient().getPatientId().toString();
            String name = updatePatientRequest.getPatient().getPatientName();
            String address  = updatePatientRequest.getPatient().getAddress();
            String email = updatePatientRequest.getPatient().getEmail();
            String phoneNo = updatePatientRequest.getPatient().getPhoneNo();
            parameters.put("patientId", patientId);
            parameters.put("patientName", name);
            parameters.put("address", address);
            parameters.put("email", email);
            parameters.put("phoneNo", phoneNo);
            HashMap<String, HashMap<String, String>> patientObject =  new HashMap<>();
            patientObject.put("patient", parameters);

            HttpEntity<?> httpEntity = new HttpEntity<Object>(patientObject, httpHeaders);

            //call the endpoint
            ResponseEntity<Object> responseEntity = restTemplate.exchange(basepathPatient.concat(putEndpoint),
                    HttpMethod.PUT,
                    httpEntity,
                    Object.class);

            //check if the call returned 200
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                try {
                    //convert responseBody to JSON
                    System.out.println(responseEntity.getBody());
                    String json = objectMapper.writeValueAsString(responseEntity.getBody());
                    //map JSON to our POJO
                    UpdatePatientResponse updatePatientResponse = objectMapper.readValue(json, UpdatePatientResponse.class);
                    return new ResponseEntity<>(updatePatientResponse, HttpStatus.OK);

                } catch (JsonProcessingException e) {
                    return new ResponseEntity<>("Error processing response as json",
                            HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            return responseEntity;
        }
    }
}


