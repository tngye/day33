package com.iss.nus.day33.controllers;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iss.nus.day33.models.Registration;
import com.iss.nus.day33.models.Response;

@RestController
@RequestMapping(path="/api/registration", produces= MediaType.APPLICATION_JSON_VALUE)
public class RegistrationRestController {

    private Logger logger = Logger.getLogger(RegistrationRestController.class.getName());
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registration(@RequestBody String payload){

        logger.info("Payload: %s".formatted(payload));
        Registration reg = new Registration();
        Response resp = new Response();
        String id = UUID.randomUUID().toString().substring(0,8);
        try{
        reg.create(payload);
        reg.setId(id);
        }catch(Exception e){
            resp = new Response();
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(resp.toJson().toString());
        }

        resp.setCode(201);
        resp.setMessage(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp.toJson().toString());
    }
}
