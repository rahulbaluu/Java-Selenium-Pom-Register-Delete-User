package testCase.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testCase.pages.HomePage;
import testCase.pages.LoginPage;
import testCase.pages.RegistrationPage;
import testCase.pages.SignupLoginPage;

import java.io.IOException;

public class NewDeleteUserStepDef {
	WebDriver driver;
	HomePage homePage;
	SignupLoginPage signupPage;
	RegistrationPage registrationPage;
	LoginPage loginPage;
	String actualUsername;
	String actualEmailAddress;
	@Given("Open the website home page")
	public void openTheWebsiteHomePage() throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/rahulbalashanmugam/Downloads/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		homePage.openHomePage();
		homePage.takeScreenshot("01_homepage");

	}

	@When("Verify the home page is visible successfully")
	public void verifyTheHomePageIsVisibleSuccessfully() throws IOException {
		homePage.verifyTheHomePageIsVisibleSuccessfully();
		homePage.takeScreenshot("02_homepage_visible");
	}

	@And("Click on Signup Login button")
	public void clickOnSignupLoginButton() throws IOException {
		homePage.clickOnSignupButton();
		homePage.takeScreenshot("03_Click_Signup_Login_button");
	}

	@And("Verify New User Signup is visible")
	public void verifyNewUserSignupIsVisible() throws IOException {
		signupPage = new SignupLoginPage(driver);
		signupPage.verifyLoginSignupPageVisible();
		homePage.takeScreenshot("04_New_User_signup_visible");
	}

	@And("Enter name, email address and click Signup button")
	public void enterNameEmailAddressAndClickSignupButton() throws IOException {
		actualUsername = "hello";
		actualEmailAddress = "r1h3l13@gmail.com";
		signupPage.enterTheNameEmailInSignupTextBox(actualUsername, actualEmailAddress);
		homePage.takeScreenshot("05_Enter_Name_Email_Address");
	}

	@And("Verify ENTER ACCOUNT INFORMATION is visible")
	public void verifyENTERACCOUNTINFORMATIONIsVisible() throws IOException {
		registrationPage = new RegistrationPage(driver);
		registrationPage.verifyTheTextPresent();
		homePage.takeScreenshot("06_Text_visible");
	}

	@And("Enter the details in the Signup form and click create Account button")
	public void enterTheDetailsInTheSignupFormAndClickCreateAccountButton() throws IOException {
		registrationPage.fillRegistrationForm();
		homePage.takeScreenshot("07_Enter_Signup_Form");
	}

	@And("Verify ACCOUNT CREATED is visible and click Continue button")
	public void verifyACCOUNTCREATEDIsVisibleAndClickContinueButton() throws IOException {
		registrationPage.verifyTheTextAccountCreated();
		homePage.takeScreenshot("08_Account_created_is_visible");
	}

	@And("Verify Login in as username is visible")
	public void verifyLoginInAsUsernameIsVisible() throws IOException {
		loginPage = new LoginPage(driver);
		loginPage.verifyLoginUserName(actualUsername);
		homePage.takeScreenshot("09_Username_Verified");
	}

	@And("Click Delete Account button")
	public void clickDeleteAccountButton() throws IOException {
		loginPage.clickDeleteAccountButton();
		homePage.takeScreenshot("10_Click_delete_account_button");
	}

	@And("Verify that Account Deleted is visible")
	public void verifyThatAccountDeletedIsVisible() throws IOException {
		loginPage.verifyAccountDeleteTextVisible();
		homePage.takeScreenshot("11_Account_deleted_text_visible");
	}

	@Then("Click Continue button and take screenshot on every step")
	public void clickContinueButtonAndTakeScreenshotOnEveryStep() {
		System.out.println("Screenshot on every step is taken");
		driver.quit();
	}

}
