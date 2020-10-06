package com.example.project.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ChromeTest {

    private WebDriver driver;

    @BeforeEach
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://tickets.oebb.at/en/ticket");

        By inputFrom = By.xpath("//div[@id='relationInputFrom']/input");
        wait.until(presenceOfElementLocated(inputFrom));
        WebElement element = driver.findElement(inputFrom);
        element.sendKeys("Wien Hbf (U)");
        wait.until(presenceOfElementLocated(By.xpath("//span[text()='Wien Hbf (U)']")));
        element.sendKeys(Keys.ENTER);

        Thread.sleep(10000);
    }
}
