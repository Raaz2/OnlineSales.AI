package com.onlinesales.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Getter
@Service
public class WolframAlphaService {
    @Value("${wolframalpha.api.appid}")
    private String appid;

    @Value("${wolframalpha.api.baseUrl}")
    private String baseUrl;
    @Autowired
    private final RestTemplate restTemplate;


    @Autowired
    public WolframAlphaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String evaluateExpression(String expression) {
        String apiUrl = baseUrl + "?appid=" + appid +  "&i=" + expression;

        return restTemplate.getForObject(apiUrl, String.class);
    }
}

