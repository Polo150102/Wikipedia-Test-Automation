package feature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\aleja\\OneDrive\\Documents\\Globant-Curso\\Repaso\\PracticeCucumberSW\\src\\test\\resources\\userSw.feature"
        ,glue={"StepDefinition"}
)
public class TestRunner {
}
