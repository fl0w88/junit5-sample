package com.example.project.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class OebbTest {

    private WebDriverWait wait;
    private WebDriver driver;
    private By byButton;

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^I am using chrome$")
    public void configureChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @And("^I am on the OEBB Ticketshop homepage$")
    public void goToOebbHomepage() {
        wait = new WebDriverWait(driver, 30);
        driver.get("https://tickets.oebb.at/en/ticket");
    }

    @And("^I search for a journey from (.+) to (.+)$")
    public void searchForJourney(String departure, String arrival) {
        By inputFrom = By.xpath("//div[@id='relationInputFrom']/input");
        wait.until(presenceOfElementLocated(inputFrom));
        WebElement element = driver.findElement(inputFrom);
        element.sendKeys(departure);
        wait.until(presenceOfElementLocated(By.xpath("//span[text()='" + departure + "']")));
        element.sendKeys(Keys.ENTER);

        By inputTo = By.xpath("//div[@id='relationInputTo']/input");
        wait.until(presenceOfElementLocated(inputTo));
        WebElement element2 = driver.findElement(inputTo);
        element2.sendKeys(arrival);
        wait.until(presenceOfElementLocated(By.xpath("//span[text()='" + arrival + "']")));
        element2.sendKeys(Keys.ENTER);

        byButton = By.xpath("//button[@aria-label='" + departure + " " + arrival + " Single Tickets and Day Tickets  ']");
    }

    @When("^I click on the find connections button$")
    public void clickButton() {
        wait.until(presenceOfElementLocated(byButton));
        WebElement button = driver.findElement(byButton);
        button.click();
    }

    @Then("^I receive a result list$")
    public void checkResult() {
        By journey = By.xpath("//div[contains(@id,'connection_')]");
        wait.until(presenceOfElementLocated(journey));
        WebElement journeyElement = driver.findElement(journey);
        journeyElement.click();
    }


}
