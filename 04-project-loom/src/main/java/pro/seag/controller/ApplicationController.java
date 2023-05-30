package pro.seag.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@AllArgsConstructor
public class ApplicationController {

    private final RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<Object> callSlowServer(){
        return restTemplate.getForEntity("http://127.0.0.1:8000", Object.class);
    }

}
