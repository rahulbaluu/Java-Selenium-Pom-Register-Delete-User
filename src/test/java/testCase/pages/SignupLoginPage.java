package testCase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class SignupLoginPage extends HomePage {
	public SignupLoginPage(WebDriver driver) {
		super(driver);
	}

	public void verifyLoginSignupPageVisible() {
		System.out.println(driver.getTitle());
		if (Objects.equals(driver.getTitle(), "Automation Exercise - Signup / Login")) {
			System.out.println("Login/Signup Page Visible Successfully");
		} else {
			System.out.println("Login/Signup Page Not Visible");
		}
	}

	public void enterTheNameEmailInSignupTextBox(String actualUsername, String actualEmailAddress) {
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(actualUsername);
		driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(actualEmailAddress);
		driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
	}
}
