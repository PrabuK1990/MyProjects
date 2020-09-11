import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_Script {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeAllTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vidhya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@BeforeMethod
	public void beforeEachTest()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] dataProviderMethod() {
		
		Object[][] dp = new Object[][] {
			{"prabu@gmail.com", "prabu@123"},
			{"kumar@gmail.com", "kumar@123"},
			{"one@gmail.com", "one@123"},
			{"two@gmail.com", "two@123"}
		};
		return dp;
		
	}

	@Test(dataProvider = "dataProviderMethod")
	public void testMethod(String email, String password) {
		driver.findElement(By.name("email")).sendKeys(email);
		System.out.println("Email Id - " + email + " - entered successfully");
		driver.findElement(By.name("pass")).sendKeys(password);
		System.out.println("Password - " + password + " - entered successfully");
	}
	
	@AfterMethod
	public void afterEachTest()
	{
		driver.navigate().refresh();
	}
	
	@AfterTest
	public void afterAllTest() throws IOException
	{
		driver.quit();
		//Email email = new Email();
		//email.sendEmail();
	}

}
