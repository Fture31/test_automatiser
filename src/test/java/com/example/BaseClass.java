package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    private ReadConfig readConfig = new ReadConfig(); // Déclaration et initialisation
    public String number1;
    public String number2;
    public String number3;
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8082/votre-application3/client/app.html");

        // Utilisation de readConfig pour obtenir les numéros
        number1 = readConfig.getNumber1();
        number2 = readConfig.getNumber2();
        number3 = readConfig.getNumber3();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
