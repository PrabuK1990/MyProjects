import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001 {

	/*@DataProvider(name = "test")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "prabu@gmail.com" }, { "kumar@gmail.com" }, {"aaa@gmail.com"} };
	}

	@Test(dataProvider = "test")
	public void testMethod(String email) {
		System.out.println("Email ID : " + email);
	}*/
	
	 @DataProvider (name = "test")
	 public Object[][] dataProviderMethod(){
	 return new Object[][] {{"prabu@gmail.com", "kumar123"}, {"kavin@gmail.com", "kavin123"}, {"ram@gmail.com", "ram123"},};
	 }
	 
	   @Test (dataProvider = "test")
	     public void myTest (String email, String password) {
		   System.out.println("Email : " + email);
		   System.out.println("Password : " + password);
	     }

}
