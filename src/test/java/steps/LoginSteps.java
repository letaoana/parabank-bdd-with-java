package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("Registered user")
    public void registeredUser() {
    }

    @When("The user attempts to login with correct credentials")
    public void theUserAttemptsToLoginWithCorrectCredentials() {
    }

    @Then("The site should login user successfully")
    public void theSiteShouldLoginUserSuccessfully() {
    }

    @When("The user attempts to login with incorrect password")
    public void theUserAttemptsToLoginWithIncorrectPassword() {
    }

    @Then("The site should not login user")
    public void theSiteShouldNotLoginUser() {
    }
}
