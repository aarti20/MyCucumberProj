package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import utility.Constant;

public class HomeStepDefinition {

	BaseClass base = new BaseClass();
	HomePage homePage;
	LoginPage loginPage;
	WebDriver driver;

	@Given("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() throws Throwable {
		driver = base.setup(Constant.browser);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);

	}

	@When("^I submit with valid username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void i_submit_username_and_password(String arg1, String arg2) throws Throwable {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		loginPage.loginToCafe(arg1, arg2);
		String name = driver.getTitle();
	}

	@Then("^I should be logged in successfully and username should be displayed as \"([^\"]*)\"$")
	public void i_should_be_logged_in_successfully_and_username_should_be_displayed_as(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String uname = loginPage.getSecondScreenUsername();
		Assert.assertEquals("Hello " + arg1, uname);
	}

	@Given("^user is already on Home page with create button name as \"([^\"]*)\"$")
	public void user_is_already_on_Home_page(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		homePage.createButton.click();

	}

	@When("^user click on Create button and enter first name as \"([^\"]*)\" and last name as \"([^\"]*)\" and start date as \"([^\"]*)\" and Email as \"([^\"]*)\"$")
	public void user_click_on_Create_button_and_enter_first_name_as_and_last_name_as_and_start_date_as_and_Email_as(
			String arg1, String arg2, String arg3, String arg4) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage.createEmployee(arg1, arg2, arg3, arg4);
	}

	@Then("^Added Employee \"([^\"]*)\"  is displayed on Home screen$")
	public void added_Employee_is_displayed_on_Home_screen(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		List<WebElement> employees = homePage.getEmployeeList();
		for (WebElement we : employees) {

			if (we.getText().equals(arg1)) {

				Assert.assertEquals(arg1, we.getText());
				break;

			}

		}

	}

	@Given("^user is already on Home page  and Employee \"([^\"]*)\" is present$")
	public void user_is_already_on_Home_page_and_Employee_is_present(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> employees = homePage.getEmployeeList();
		for (WebElement we : employees) {

			if (we.getText().equals(arg1)) {
				we.click();

				break;

			}

		}

	}

	@When("^user select Employee name \"([^\"]*)\" and Delete the Employee$")
	public void user_select_Employee_name_and_Delete_the_Employee(String arg1) throws Throwable {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		homePage.deleteButton.click();

		driver.switchTo().alert().accept();

	}

	@Then("^Employee \"([^\"]*)\" is deleted from Home screen bu user \"([^\"]*)\"$")
	public void employee_is_deleted_from_Home_screen_bu_user(String arg1, String arg2) throws Throwable {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		homePage.logoutButton.click();

		loginPage.setUserName(arg2);

		loginPage.clickLogin();

		List<WebElement> employees = homePage.getEmployeeList();

		for (WebElement we : employees) {

			if (we.getText().equals(arg1)) {

				Assert.assertEquals(we.getText(), arg1);

				break;

			}

		}
	}
}