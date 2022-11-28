package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java",glue="Selenium.SeleniumFrameworkDesignStepDefinition",
monochrome=true, tags = "@Add", plugin= {"html:target/cucumber.html"})		
public class TestNGTestRunner extends AbstractTestNGCucumberTests
{

	
	
}
