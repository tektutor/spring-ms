package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.Arrays;

@RestController
public class Receiver {
   @Autowired
   RestTemplate restTemplate;

   @RequestMapping("/")
   public String invokeFirstMicroservice() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
      HttpEntity <String> entity = new HttpEntity<String>(headers);

      return restTemplate.exchange(
         "http://sender-ms.jegan.svc.cluster.local:8080", HttpMethod.GET, entity, String.class).getBody();
   }
}
