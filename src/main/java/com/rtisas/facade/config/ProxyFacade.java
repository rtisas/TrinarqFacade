package com.rtisas.facade.config;

import lombok.Data;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Data
public class ProxyFacade {

    private final RestTemplate service;

    public ProxyFacade(RestTemplate service){
        this.service = service;
    }

    public ResponseEntity<Object> postServiceAPI(String URL, HttpMethod method, HttpEntity<?> request, Class<?> responseType) {
        ResponseEntity<?> result;
        try {
            result = service.exchange(URL, method, request, responseType);
                return ResponseEntity.ok().body(result.getBody());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage().substring(7, e.getMessage().length()-1));
        }

    }

    public ResponseEntity<Object> postServiceAPI(String URL, HttpMethod method, HttpEntity<?> request, Class<?> responseType, Map<String, ?> params) {
        ResponseEntity<?> result;
        try {
            result = service.exchange(URL, method, request, responseType, params);
            return ResponseEntity.ok().body(result.getBody());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.badRequest().body("Error por parte del servidor\nCode: " + e.getStatusCode().value() + "\nMessage: " + e.getStatusCode().getReasonPhrase());
        }
    }


}
