package com.demoapp.votingpoll.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@Data
public class CpfValidationService {

    @Value("${cpfValidation.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public boolean isCpfValid(String cpf) {
        log.info("Validating cpf at: {}", cpf);
        ResponseEntity<String> response = restTemplate.getForEntity(url.concat("/").concat(cpf), String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().contains("ABLE_TO_VOTE");
        }
        log.info("Cpf could not be validated");
        return false;
    }

}
