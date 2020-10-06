package com.example.project.cucumber.steps;

import com.example.project.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class CalculatorTest {

    Calculator c;
    double r;

    @Given("^I am using my calculator$")
    public void initCalculator() {
        c = new Calculator();
    }

    @When("^I add (.+) and (.+)$")
    public void addNumbers(double a, double b) {
        r = c.add(a, b);
        System.out.println(a + " + " + b + " = " + r);
    }

    @When("^I subtract (.+) and (.+)$")
    public void subNumbers(double a, double b) {
        r = c.subtract(a, b);
    }

    @Then("^I get the result (.+)$")
    public void verifyResult(double e) {
        Assertions.assertEquals(e, r);
    }

}
