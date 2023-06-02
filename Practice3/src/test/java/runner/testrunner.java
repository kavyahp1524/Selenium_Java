package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features =("src/test/resources/Orangehrm/hrm.feature"),glue= {"defination"},dryRun = false)
public class testrunner extends AbstractTestNGCucumberTests {

}
