package com.example.project.keywords;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base64Keywords {

    private static WebDriver driver;
    private WebDriverWait wait = null;

    private void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void close() {
        driver.close();
    }

    public Base64Keywords() {
        super();
    }

    public void openBase64Site() {
        init();
        driver.get("https://www.base64encode.org/");
    }

}
