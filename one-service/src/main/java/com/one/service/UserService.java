package com.one.service;

import com.google.gson.Gson;
import com.one.modal.NameInput;
import com.one.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;


    public String createMessage(NameInput msg){
        log.info(new Gson().toJson(msg));
        return fetchHello() + " " + getLog(msg);
    }

    public String fetchHello() {
        ResponseEntity<String> response = restTemplate.exchange("http://service-two/two", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

    public String getLog(NameInput msg) {
        HttpEntity entity = new HttpEntity(msg);

        ResponseEntity<String> response = restTemplate.exchange("http://service-three/three", HttpMethod.POST, entity, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

}
