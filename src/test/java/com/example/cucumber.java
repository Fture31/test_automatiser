package com.example;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class cucumber {
    private WebDriver driver;
    private double number1;
    private double number2 ; 
    private double number3;
    private double[] result;
    private EquationSolver equationSolver = new EquationSolver();



    @Given("l'équation du second degré avec coefficients a = {int}, b = {int}, c = {int}")
public void l_équation_du_second_degré_avec_coefficients_a_b_c(Integer int1, Integer int2, Integer int3)  {
    // Configuration du WebDriver
    // System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    driver = new ChromeDriver();
    
    // Write code here that turns the phrase above into concrete actions
    driver.get("http://localhost:8082/votre-application4/client/app.html");
    number1 = int1;
    number2 = int2; 
    number3 = int3; 

}
@When("je résous l'équation")
public void je_résous_l_équation() {
    // Récupérer les éléments du formulaire
    WebElement number1Input = driver.findElement(By.id("number1"));
    WebElement number2Input = driver.findElement(By.id("number2"));
    WebElement number3Input = driver.findElement(By.id("number3"));
    WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

    // Saisir les valeurs dans le formulaire
    number1Input.sendKeys(String.valueOf(number1));
    number2Input.sendKeys(String.valueOf(number2));
    number3Input.sendKeys(String.valueOf(number3));

    result = equationSolver.solve(number1, number2, number3);
    
    // Cliquer sur le bouton Envoyer
    submitButton.click();
    if (result.length!=0) Assert.assertTrue(true);
    else 
        Assert.assertTrue(false);
}
@Then("les solutions de l'équation sont x1 = {int} et x2 = {int}")
public void les_solutions_de_l_équation_sont_x1_et_x2(Integer int1, Integer int2) {
    
    if(result[0] == int1 && result[1] == int2) Assert.assertTrue(true);
    else 
        Assert.assertTrue(false);

    driver.quit();
}


//-------------------------------------------------------------------------------------------------


    
}
