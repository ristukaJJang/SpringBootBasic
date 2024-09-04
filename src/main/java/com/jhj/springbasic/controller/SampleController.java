package com.jhj.springbasic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhj.springbasic.dto.PostSample1RequestDto;
import com.jhj.springbasic.service.SampleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleSerivce;

    @PostMapping("")
    public ResponseEntity<String> postSample1(
        @RequestBody @Valid PostSample1RequestDto requestBody
    ) {
        ResponseEntity<String> response = sampleSerivce.postSample1(requestBody);
        return response;
    } 

    @DeleteMapping("/{sampleId}")
    public ResponseEntity<String> deleteSample1(
        @PathVariable("sampleId") String sampleId
    ) {
        ResponseEntity<String> response = sampleSerivce.deleteSample1(sampleId);
        return response;
    }


    @GetMapping("")
    public ResponseEntity<String> queryMethod() {
        ResponseEntity<String> response = sampleSerivce.queryString();
        return response;
    }
    
    @GetMapping("/jwt/{name}")
    public String getJwt(
        @PathVariable("name") String name
    ) {
        String response = sampleSerivce.getJwt(name);
        return response;
    }

    @PostMapping("/jwt")
    public String validateJwt(
        @RequestBody String jwt
    ) {
        
        String reaponse = sampleSerivce.validateJwt(jwt);
        return reaponse;
    }
    
}