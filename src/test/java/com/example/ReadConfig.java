package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

/**
 * ReadConfig
 */
public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        File file = new File("Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(file);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("L'exception est : " + e.getMessage());
        }
    }

    public String getLoginBaseURL() {
        return pro.getProperty("LoginBaseURL");
    }

    public String getGoogleBaseURL() {
        return pro.getProperty("GoogleBaseUFL");
    }

    public String getNumber1() {
        return pro.getProperty("number1");
    }

    public String getNumber2() {
        return pro.getProperty("number2");
    }
    public String getNumber3() {
        return pro.getProperty("number3");
    }


    // Méthode pour prendre une capture d'écran
    public void takeScreenshot(TakesScreenshot driver) throws IOException {
        // File screen = driver.getScreenshotAs(OutputType.FILE);
        // Ajoutez votre logique pour enregistrer la capture d'écran, par exemple :
        // Files.copy(screen, new File("chemin/vers/le/dossier/screenshots/login.jpg"));
        try {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File("Screenshots/login.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

// File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);