package com.example.project.server;

import com.example.project.Calculator;
import com.example.project.server.model.CalculationRequest;
import com.example.project.server.model.CalculationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping(value = "/calculator", consumes = "application/json", produces = "application/json")
    public CalculationResponse calc(@RequestBody CalculationRequest calculationRequest) {
        Calculator calc = new Calculator();
        BigDecimal r = null;
        if (calculationRequest.getO().trim().equals("-")) {
            r = calc.subtract(calculationRequest.getA(), calculationRequest.getB());
        }
        if (calculationRequest.getO().trim().equals("+")) {
            r = calc.add(calculationRequest.getA(), calculationRequest.getB());
        }
        if (calculationRequest.getO().trim().equals("*")) {
            r = calc.multiply(calculationRequest.getA(), calculationRequest.getB());
        }
        if (calculationRequest.getO().trim().equals("/")) {
            r = calc.divide(calculationRequest.getA(), calculationRequest.getB());
        }
        return new CalculationResponse(r);
    }

}
