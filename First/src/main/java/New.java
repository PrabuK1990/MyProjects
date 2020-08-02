import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New {
	

	@BeforeTest
	public void beforeAllMethod()
	{
		System.out.println("Execution Starts");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Enter URL");
	}
	
	@Test
	public void testCase_001()
	{
		System.out.println("Test Case 001");
	}
	
	@Test
	public void testCase_002()
	{
		System.out.println("Test Case 002");
	}
	
	@Test
	public void testCase_003()
	{
		System.out.println("Test Case 003");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Page Refresh");
	}
	
	@AfterTest
	public void afterAllMethod() throws IOException 
	{
		Email email = new Email();
		email.sendEmail();
	}  
}
