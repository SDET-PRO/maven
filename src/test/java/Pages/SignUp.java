package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.maven.ApplicationKeywords;

public class SignUp extends ApplicationKeywords {

	// WebDriver driver;
	int globalCount = 3;
	int count = 1;

	public SignUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user_name']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@id='user_email']")
	@CacheLookup
	WebElement userEmail;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//input[@type='checkbox']")
	@CacheLookup
	WebElement checkbox;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement submit;

	public void enterTextInField(String fieldName, String value, String type) {
		try {
			if (type.equals("1")) {
				WebElement element = driver.findElement(By.xpath("//label[text()='" + fieldName + "']/..//input"));

				if (isElementDisplayed(element, 10)) {
					element.clear();
					element.sendKeys(value);
					element.sendKeys(Keys.TAB);
				} else {
					// System.out.println();
					throw new NoSuchElementException();
				}
			} else if (type.equals("2")) {
				switch (fieldName) {
				case "UserName":
					if (isElementDisplayed(userName, 10)) {
						userName.clear();
						userName.sendKeys(value);
						userName.sendKeys(Keys.TAB);
					} else {
						// System.out.println();
						throw new NoSuchElementException();
					}
					break;
				case "Password":
					if (isElementDisplayed(password, 10)) {
						password.clear();
						password.sendKeys(value);
						password.sendKeys(Keys.TAB);
					} else {
						 System.out.println();
						throw new NoSuchElementException();
					}
					break;
				case "UserEmail":
					if (isElementDisplayed(userEmail, 10)) {
						userEmail.clear();
						userEmail.sendKeys(value);
						userEmail.sendKeys(Keys.TAB);
					} else {
						// System.out.println();
						throw new NoSuchElementException();
					}
					break;
				default:
					break;
				}
			}
		} catch (NoSuchElementException e) {

			if (count <= globalCount) {
				count++;
				driver.navigate().refresh();
				driver.getPageSource();
				enterTextInField(fieldName, value, type);
			} else {
				System.out.println(fieldName + " field not available in the webpage.");
				count = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			System.out.println(e.getLocalizedMessage());

		}
	}

	public void checkbox() {
		try {

			if (isElementDisplayed(checkbox, 10)) {
				checkbox.click();

			} else {
				throw new NoSuchElementException();

			}

		} catch (NoSuchElementException e) {

			if (count <= globalCount) {
				count++;
				driver.navigate().refresh();
				driver.getPageSource();
				checkbox();
			} else {
				System.out.println("Checkbox is not available");
				count = 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	public void buttonClick() {
		try {

			if (isElementDisplayed(submit, 10)) {
				submit.click();

			} else {
				throw new NoSuchElementException();

			}

		} catch (NoSuchElementException e) {

			if (count <= globalCount) {
				count++;
				driver.navigate().refresh();
				driver.getPageSource();
				buttonClick();
			} else {
				System.out.println("Button is not available");
				count = 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

}
