package com.onlinesales.controller;

import com.onlinesales.service.WolframAlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MathController {

    private final WolframAlphaService wolframAlphaService;

    @Autowired
    public MathController(WolframAlphaService wolframAlphaService) {
        this.wolframAlphaService = wolframAlphaService;
    }

    @PostMapping("/evaluate")
    public String evaluateExpression(@RequestBody String expression) {
        StringBuilder sb = new StringBuilder();
        String[] arr = expression.split("\n");
        for (String str : arr) {
            if (str.equalsIgnoreCase("end")) break;
            else {
                String ans = wolframAlphaService.evaluateExpression(str);
                sb.append(str).append(" => ").append(ans).append("\n");
            }
        }
        return sb.toString().trim();
    }
}

