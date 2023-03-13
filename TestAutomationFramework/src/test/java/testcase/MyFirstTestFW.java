package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class MyFirstTestFW extends BaseTest {

	@Test(dataProviderClass = ReadXLSdata.class, dataProvider = "bvtdata")
	public static void LoginTest(String username, String password) throws InterruptedException {
		System.out.println("Clicked Successfully");
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.id(loc.getProperty("next_button"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("pwd"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
		Thread.sleep(2000);
		// driver.logintoZoho("user", "password");
	}
}