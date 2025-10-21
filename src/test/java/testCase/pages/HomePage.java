package testCase.pages;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class HomePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void openHomePage() {
		driver.get("https://www.automationexercise.com/");
		driver.findElement(By.cssSelector("p.fc-button-label")).click(); // Consent
	}
	public void verifyTheHomePageIsVisibleSuccessfully() {
		driver.getTitle();
		System.out.println(driver.getTitle());
		if(Objects.equals(driver.getTitle(), "Automation Exercise")) {
			System.out.println("Home page is visible successfully");
		}
		else {
			System.out.println("Home page is not visible successfully");
		}
	}

	public void clickOnSignupButton() {
		driver.findElement(By.linkText("Signup / Login")).click();
	}
	public void takeScreenshot(String fileName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/" + fileName + ".png"));
	}
}
