package steps;

import com.github.javafaker.Faker;
import constants.SystemPropertyName;
import customer.Customer;
import customer.CustomerAddress;
import dataprovider.ConfigFileReader;
import constants.FieldIdentifier;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.RegisterPage;
import utils.Magic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterSteps {
    private Faker faker;
    private WebDriver driver;
    private Customer customer;
    private CustomerAddress customerAddress;
    private RegisterPage registerPage;


    @BeforeAll
    public static void before(){
        WebDriverManager.edgedriver().setup();
    }

    @Before("@CustomerRegister")
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        faker = new Faker();
        registerPage = new RegisterPage(driver);
    }

    @Given("New customer with valid data")
    public void newCustomerWithValidData() {
        customer = new Customer(faker);
        customerAddress = new CustomerAddress(faker);
    }

    @When("The customer submits complete Register form")
    public void theCustomerSubmitsCompleteRegisterForm() {
        registerPage.setFirstName(customer.getFirstName())
                    .setLastName(customer.getLastName())
                    .setAddress(customerAddress.getAddress())
                    .setCity(customerAddress.getCity())
                    .setState(customerAddress.getState())
                    .setZipCode(customerAddress.getZipCode())
                    .setSsn(customer.getSsn())
                    .setUsername(customer.getUsername())
                    .setPassword(customer.getPassword())
                    .setConfirm(customer.getPassword())
                    .clickRegisterButton();
    }

    @When("The customer submits Register form with a {string} field not set")
    public void theCustomerSubmitsRegisterFormWithAFieldNotSet(String fieldId) {
        registerPage.setFirstName(fieldId.equals(FieldIdentifier.FIRST_NAME_ID) ? "" : customer.getFirstName())
                    .setLastName(fieldId.equals(FieldIdentifier.LAST_NAME_ID) ? "" : customer.getLastName())
                    .setAddress(fieldId.equals(FieldIdentifier.ADDRESS_ID) ? "" : customerAddress.getAddress())
                    .setCity(fieldId.equals(FieldIdentifier.CITY_ID) ? "" : customerAddress.getCity())
                    .setState(fieldId.equals(FieldIdentifier.STATE_ID) ? "" : customerAddress.getState())
                    .setZipCode(fieldId.equals(FieldIdentifier.ZIPCODE_ID) ? "" : customerAddress.getZipCode())
                    .setSsn(fieldId.equals(FieldIdentifier.SSN_ID) ? "" : customer.getSsn())
                    .setUsername(fieldId.equals(FieldIdentifier.USERNAME_ID) ? "" : customer.getUsername())
                    .setPassword(fieldId.equals(FieldIdentifier.PASSWORD_ID) ? "" : customer.getPassword())
                    .setConfirm(fieldId.equals(FieldIdentifier.CONFIRM_ID) ? "" : customer.getPassword())
                    .clickRegisterButton();
    }


    @Then("The customer should be registered successfully")
    public void theCustomerShouldBeRegisteredSuccessfully() {
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText();
        assertThat(actualMessage, equalTo(expectedMessage));
    }

    @Given("New customer with invalid data")
    public void newCustomerWithInvalidData() {
        customer = new Customer(faker);
        customerAddress = new CustomerAddress(faker);
    }

    @After("@CustomerRegister")
    public void teardown(){
        LogOut();
        driver.quit();
    }

    private void LogOut(){

        var logOutLinks = driver.findElements(By.linkText("Log Out"));
        if(!logOutLinks.isEmpty()){
            logOutLinks.get(0).click();
        }
    }

    @Then("{string} field error should be displayed")
    public void fieldShouldBeDisplayed(String fieldId) {
        String expectedErrorMessage = Magic.getFieldErrorMessage(fieldId);
        String actualErrorMessage = registerPage.GetFormInputFieldError(fieldId);
        assertThat(actualErrorMessage, equalTo(expectedErrorMessage));
    }
}
