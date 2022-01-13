package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.maven.ApplicationKeywords;
import com.project.maven.Utility;

import Pages.SignUp;

public class US_SignUp extends ApplicationKeywords {

	public SignUp signup ;
	@Test(dataProvider="fetchExcel")
	public void signup(String userName,String password, String email) throws EncryptedDocumentException, IOException, InterruptedException
	{
		signup = new SignUp(driver);
		/*String userName = Utility.excelUtil("signup-001", "UserName", "Sheet1");
		String password = Utility.excelUtil("signup-001", "Password", "Sheet1");
		String email = Utility.excelUtil("signup-001", "Email", "Sheet1");*/


		signup.enterTextInField("UserName", userName, "2"); 
		signup.enterTextInField("UserEmail", email, "2"); 
		signup.enterTextInField("Password", password, "2"); 
		signup.checkbox();
		signup.buttonClick();
		Thread.sleep(5000);
	}

	@DataProvider(name="fetchExcel")
	public String[][] signUpData()
	{
		String[][] ob= Utility.excelUtilForDataprovider("signup-002", "Sheet1");
		return ob;
		
	}
}
