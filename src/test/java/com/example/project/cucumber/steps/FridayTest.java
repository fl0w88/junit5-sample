package com.example.project.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Calendar;

public class FridayTest {

    @Given("^today is Sunday$")
    public void todayIsSunday() {
        // TODO
    }

    @When("^I ask whether it's Friday yet$")
    public void askForFriday() {
        // TODO
    }

    @Then("^I should be told (.+)$")
    public void answer(String todaysAnswer) {
        Assertions.assertEquals(todaysAnswer, isTodaySunday());
    }

    private String isTodaySunday() {
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (currentDay == 1) {
            return "Yes";
        }
        return "Nope";
    }

}
