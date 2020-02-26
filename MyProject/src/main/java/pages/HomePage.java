package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id=\"bAdd\"]")
	public WebElement createButton;

	@FindBy(how = How.XPATH, using = "//*[@name=\"employeeForm\"]/fieldset/label[1]/input")
	public WebElement firstName;

	@FindBy(how = How.XPATH, using = "//*[@name=\"employeeForm\"]/fieldset/label[2]/input")
	public WebElement lastName;

	@FindBy(how = How.XPATH, using = "//*[@name=\"employeeForm\"]/fieldset/label[3]/input")
	public WebElement startDate;

	@FindBy(how = How.XPATH, using = "//*[@name=\"employeeForm\"]/fieldset/label[4]/input")
	public WebElement email;

	@FindBy(how = How.XPATH, using = "//*[@name=\"employeeForm\"]/fieldset/div/button[2]")
	public WebElement addButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"bEdit\"]")
	public WebElement editButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"bDelete\"]")
	public WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"employee-list\"]/li")
	public List<WebElement> allEmployee;

	@FindBy(how = How.XPATH, using = "//*[@class=\"main-button\"]")
	public WebElement logoutButton;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void setFirstName(String strEmpFirstName) {

		firstName.sendKeys(strEmpFirstName);
	}

	public void setLastName(String strEmpLasttName) {

		lastName.sendKeys(strEmpLasttName);
	}

	public void setStartDate(String strStartdate) {

		startDate.sendKeys(strStartdate);
	}

	public void setEmail(String strEmail) {

		email.sendKeys(strEmail);
	}

	public void clickAdd() {

		addButton.click();

	}

	public List getEmployeeList() {

		return allEmployee;

	}

// Verify message with invalid credential

	public void createEmployee(String strEmpFirstName, String strEmpLasttName, String strStartdate, String strEmail) {

		this.setFirstName(strEmpFirstName);

		this.setLastName(strEmpLasttName);

		this.setStartDate(strStartdate);

		this.setEmail(strEmail);

		this.clickAdd();

	}

}
