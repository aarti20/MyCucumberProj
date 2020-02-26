package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/label[1]/input")
	public WebElement username;

	@FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/label[2]/input")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/button")
	public WebElement loginButton;

	@FindBy(how = How.XPATH, using = "/html/head/title")
	public WebElement SecondScreenTitle;

	@FindBy(how = How.XPATH, using = "//*[@id=\"greetings\"]")
	public WebElement usernameOnScecondScreen;

	@FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/p[1]")
	public WebElement invalidLoginMessage;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void setUserName(String strUserName) {

		username.sendKeys(strUserName);
	}

	public String getUserName() {

		return (this.username.getText());
	}

	public void setPassword(String strPassword) {

		password.sendKeys(strPassword);

	}

	public void clickLogin() {

		loginButton.click();

	}

	public String getSecondScreenUsername() {

		return usernameOnScecondScreen.getText();

	}

// Verify message with invalid credential
	public String invalidLoginMessage() {

		return invalidLoginMessage.getText();

	}

	public void loginToCafe(String strUserName, String strPasword) {

		this.setUserName(strUserName);

		this.setPassword(strPasword);

		this.clickLogin();

	}

}
