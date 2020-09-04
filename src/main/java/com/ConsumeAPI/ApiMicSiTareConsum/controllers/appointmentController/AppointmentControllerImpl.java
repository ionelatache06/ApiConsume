package com.ConsumeAPI.ApiMicSiTareConsum.controllers.appointmentController;

import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.addAppointment.AddAppointmentRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.addAppointment.AddAppointmentResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.deleteAppointment.DeleteAppointmentResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.getappointment.GetAppointmentResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.updateAppointment.UpdateAppointmentRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.appointmentModel.updateAppointment.UpdateAppointmentResponse;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.addPatient.AddPatientRequest;
import com.ConsumeAPI.ApiMicSiTareConsum.model.patientModel.addPatient.AddPatientResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class AppointmentControllerImpl implements AppointmentController {

    @Value("${mvc.basepathAppointment}")
    private String basepathAppointment;

    @Value("${mvc.getEndpoint}")
    private String getEndpoint;

    @Value("${mvc.postEndpoint}")
    private String postEndpoint;

    @Value("${mvc.putEndpoint}")
    private String putEndpoint;

    @Value("${mvc.deleteEndpoint}")
    private String deleteEndpoint;

    @Autowired
    private ObjectMapper objectMapper;

   @Override
    public ResponseEntity<?> displayAppointment(Optional<Integer> appointmentId, Optional<LocalDate> appointmentDate){
        RestTemplate restTemplate = new RestTemplate();
        //case appointmentId is preset
        if (appointmentId.isPresent() && appointmentDate.isEmpty()){
            //adding headers
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            //wrap the headers
            HttpEntity httpEntity = new HttpEntity(httpHeaders);

            //call the endpoint
            ResponseEntity<String> responseEntity = restTemplate.exchange(basepathAppointment.concat(getEndpoint).
                            concat("?appointmentId={id}"),
                    HttpMethod.GET,
                    httpEntity,
                    String.class,
                    appointmentId.get());

            //check if the call returned 200
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                try {
                    //convert responseBody to JSON
//                    String json = objectMapper.writeValueAsString(responseEntity.getBody());
                    //map JSON to our POJO
                    GetAppointmentResponse getAppointmentResponse = objectMapper.readValue(responseEntity.getBody(),
                            GetAppointmentResponse.class);
                    return new ResponseEntity<>(getAppointmentResponse, HttpStatus.OK);

                } catch (JsonProcessingException e) {
                    return new ResponseEntity<>("Error processing response as json", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            return  responseEntity;
        }
        return null;
    }

    @Override
    public ResponseEntity<?> addAppointmentRest(@RequestBody AddAppointmentRequest addAppointmentRequest) {
        RestTemplate restTemplate = new RestTemplate();
        //adding headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<Object>(addAppointmentRequest, httpHeaders);

        //call the endpoint
        ResponseEntity<Object> responseEntity = restTemplate.exchange(basepathAppointment.concat(postEndpoint),
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
                AddAppointmentResponse addAppointmentResponse = objectMapper.readValue(json, AddAppointmentResponse.class);
                return new ResponseEntity<>(addAppointmentResponse, HttpStatus.OK);

            } catch (JsonProcessingException e) {
                return new ResponseEntity<>("Error processing response as json",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return responseEntity;
    }

    /*@Override
    public ResponseEntity<?> addAppointmentRest(AddAppointmentRequest addAppointmentRequest) {
        RestTemplate restTemplate = new RestTemplate();
        {
            //adding headers
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            HashMap<String, String> parameters = new HashMap<>();
            String patientName = addAppointmentRequest.getAppointment().getPatientName();
            String doctorName  = addAppointmentRequest.getAppointment().getDoctorName();
            String appointmentDate = addAppointmentRequest.getAppointment().getAppointmentDate().toString();
            String appointmentTime = addAppointmentRequest.getAppointment().getAppointmentTime().toString();
            parameters.put("patientName", patientName);
            parameters.put("doctorName", doctorName);
            parameters.put("appointmentDate", appointmentDate);
            parameters.put("appointmentTime", appointmentTime);
            HashMap<String, HashMap<String, String>> appointmentObject =  new HashMap<>();
            appointmentObject.put("appointment", parameters);

            HttpEntity<?> httpEntity = new HttpEntity<Object>(appointmentObject, httpHeaders);

            //call the endpoint
            ResponseEntity<Object> responseEntity = restTemplate.exchange(basepathAppointment.concat(postEndpoint),
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
                    AddAppointmentResponse addAppointmentResponse = objectMapper.readValue(json, AddAppointmentResponse.class);
                    return new ResponseEntity<>(addAppointmentResponse, HttpStatus.OK);

                } catch (JsonProcessingException e) {
                    return new ResponseEntity<>("Error processing response as json",
                            HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            return responseEntity;
        }
    }*/

    @Override
    public ResponseEntity<?> updateAppointmentRest(@RequestBody UpdateAppointmentRequest updateAppointmentRequest) {
        RestTemplate restTemplate = new RestTemplate();
        //adding headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<Object>(updateAppointmentRequest, httpHeaders);

        //call the endpoint
        ResponseEntity<Object> responseEntity = restTemplate.exchange(basepathAppointment.concat(putEndpoint),
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
                UpdateAppointmentResponse updateAppointmentResponse = objectMapper.readValue(json, UpdateAppointmentResponse.class);
                return new ResponseEntity<>(updateAppointmentResponse, HttpStatus.OK);

            } catch (JsonProcessingException e) {
                return new ResponseEntity<>("Error processing response as json",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<?> deleteAppointmentRest(@RequestParam Optional<Integer> appointmentId){
        RestTemplate restTemplate = new RestTemplate();
        //adding headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<Object>(httpHeaders);

        //call the endpoint
        ResponseEntity<String> responseEntity = restTemplate.exchange(basepathAppointment.concat(deleteEndpoint).
                        concat("?appointmentId={id}"),
                HttpMethod.DELETE,
                httpEntity,
                String.class,
                appointmentId.get());

        //check if the call returned 200
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            try {
                //convert responseBody to JSON
                System.out.println(responseEntity.getBody());
                String json = objectMapper.writeValueAsString(responseEntity.getBody());
                //map JSON to our POJO
                DeleteAppointmentResponse deleteAppointmentResponse = objectMapper.readValue(json, DeleteAppointmentResponse.class);
                return new ResponseEntity<>(deleteAppointmentResponse, HttpStatus.OK);

            } catch (JsonProcessingException e) {
                return new ResponseEntity<>("Error processing response as json",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return responseEntity;
    }
}


