package testCase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends HomePage {
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	public void verifyTheTextPresent(){
		String expectedText = "ENTER ACCOUNT INFORMATION";
		WebElement element = driver.findElement(By.xpath("//h2[@class='title text-center']"));
		if(element.isDisplayed() && element.getText().equals(expectedText)){
			System.out.println("Text Present");
		}
		else{
			System.out.println("Text Not Present");
		}
	}

	public void fillRegistrationForm() {
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys("hellorahu");
		//Selecting the dropdown
		WebElement DayDropdown = driver.findElement(By.id("days"));
		Select Daydropdown = new Select(DayDropdown);
		Daydropdown.selectByIndex(3);

		WebElement MonthDropdown = driver.findElement(By.id("months"));
		Select Monthdropdown = new Select(MonthDropdown);
		Monthdropdown.selectByIndex(2);

		WebElement YearDropdown = driver.findElement(By.id("years"));
		Select Yeardropdown = new Select(YearDropdown);
		Yeardropdown.selectByValue("2020");

		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("first_name")).sendKeys("hello");
		driver.findElement(By.id("last_name")).sendKeys("world");
		driver.findElement(By.id("company")).sendKeys("gmail");
		driver.findElement(By.id("address1")).sendKeys("Flat no 1");
		driver.findElement(By.id("address2")).sendKeys("Town 1");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("state")).sendKeys("Tamilnadu");
		driver.findElement(By.id("city")).sendKeys("cbe");
		driver.findElement(By.id("zipcode")).sendKeys("12345");
		driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	public void verifyTheTextAccountCreated() {
		String ExpectedText = "ACCOUNT CREATED!";
		WebElement element = driver.findElement(By.cssSelector("h2[data-qa='account-created']"));
		if(element.isDisplayed() && element.getText().equals(ExpectedText)){
			System.out.println("Account Created Visible");
			driver.findElement(By.linkText("Continue")).click();
		}
		else{
			System.out.println("Account Created Visible");
		}
	}
}
