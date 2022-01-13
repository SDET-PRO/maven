package com.project.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Base {

	public WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void start(String browser) {
		// Setting system properties of ChromeDriver
		if (browser.equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
			// Creating an object of ChromeDriver
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();

		// Deleting all the cookies
		driver.manage().deleteAllCookies();

		// Specifiying pageLoadTimeout and Implicit wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// launching the specified URL
		driver.get("https://sso.teachable.com/secure/9521/identity/sign_up/with_email");

	}

}
