package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/login/Apna.feature"},glue={"defination"},dryRun = false)

public class apnarunner extends AbstractTestNGCucumberTests{

}
