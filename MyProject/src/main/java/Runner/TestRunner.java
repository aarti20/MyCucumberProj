package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;
import com.vimalselvam.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/main/java/Features" }, tags = { "@Login,@Home" }, glue = {
		"stepDefinitions" }, plugin = { "pretty", "html:target/cucumber-reports", "html:target/cucumber-html-report",
				"json:target/cucumber-json-report.json" })

public class TestRunner {

}
