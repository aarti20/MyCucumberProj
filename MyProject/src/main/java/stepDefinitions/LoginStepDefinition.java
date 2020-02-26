package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BaseClass;
import pages.LoginPage;
import utility.Constant;

public class LoginStepDefinition {

	BaseClass base = new BaseClass();
	LoginPage loginPage;
	WebDriver driver;

	@Given("^user is already on Login page$")
	public void user_is_already_on_Login_page() throws Throwable {
		driver = base.setup(Constant.browser);
		loginPage = new LoginPage(driver);
	}

	@When("^user submit valid username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enter_username_as_and_password_as(String arg1, String arg2) throws Throwable {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		loginPage.loginToCafe(arg1, arg2);
		String name = driver.getTitle();

	}

	@Then("^user logged in successfully and username should be displayed as \"([^\"]*)\"$")
	public void user_logged_in_successfully_and_username_should_be_displayed_as(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String uname = loginPage.getSecondScreenUsername();
		Assert.assertEquals("Hello " + arg1, uname);

	}

	@When("^user enter invalid username as \"([^\"]*)\" and invalid password as \"([^\"]*)\"$")
	public void user_enter_invalid_username_as_and_invalid_password_as(String arg1, String arg2) throws Throwable {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPage.loginToCafe(arg1, arg2);

	}

	@Then("^user should not be logged in and invalid message shoud be displayed as \"([^\"]*)\"$")
	public void user_should_not_be_logged_in_and_invalid_message_shoud_be_displayed_as(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String message = loginPage.invalidLoginMessage();

		Assert.assertEquals(arg1, message);

	}
}
