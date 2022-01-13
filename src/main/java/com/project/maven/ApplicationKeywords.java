package com.project.maven;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationKeywords extends Base {

	
	public boolean isElementDisplayed(WebElement we, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOf(we));
		
		if(element.isDisplayed() || element.isEnabled())
		{
			return true;
		}
		
		return false;
		
	}
	
	public void waitTillElementVisible(WebElement we, int timeout)
	{
		
        WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOf(we));
		
		
	}
}
