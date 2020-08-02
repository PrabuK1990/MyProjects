package StepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	@Before
	public void init() {
	    System.out.println("Before test suite");
	}
	
	@After
    public void finalize() {
		System.out.println("After test suite");
    }
	
	@Given("^User is {pwd} on Home Page$")
	public void user_is_on_Home_Page(String pwd) throws Throwable {
		System.out.println("vvv" + pwd);
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		System.out.println("uuu");
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {

	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    
	}


}
