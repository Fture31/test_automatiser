package com.example;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    stepNotifications = true,
    features = "src/test/java/com/example/github.feature",
    plugin = {"pretty", "json:target1/json/results.json"},
    glue={""}
    // features = "src/test/java/com/example/GoogleSearch.feature",
    // plugin = {"pretty", "json:target1/json/results.json"},
    // monochrome = true
    // glue = {"classpath"},
    //tags = {""}

)
public class stepTest {
    
}
