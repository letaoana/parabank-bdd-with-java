package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WithdrawSteps {
    @Given("Account with positive balance")
    public void accountWithPositiveBalance() {
    }

    @When("The user request a withdrawal for a lesser amount")
    public void theUserRequestAWithdrawalForALesserAmount() {
    }

    @Then("The withdrawal should be successful")
    public void theWithdrawalShouldBeSuccessful() {
    }

    @Given("Account with negative balance")
    public void accountWithNegativeBalance() {
    }

    @When("The user request a withdrawal for a greater amount")
    public void theUserRequestAWithdrawalForAGreaterAmount() {
    }

    @Then("The withdrawal should not be successful")
    public void theWithdrawalShouldNotBeSuccessful() {
    }
}
