package steps;

import com.github.javafaker.Faker;
import customer.Customer;
import customer.CustomerAddress;
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
import pages.LoginPage;
import pages.RegisterPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps {
    private Faker faker;
    private LoginPage loginPage;
    private Customer customer;
    private WebDriver driver;

    @BeforeAll
    public static void before() {
        WebDriverManager.edgedriver().setup();
    }

    @Before("@CustomerLogin")
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        faker = new Faker();

        loginPage = new LoginPage(driver);
    }

    @Given("Registered user")
    public void registeredUser() {
        customer = new Customer(faker);
        var customerAddress = new CustomerAddress(faker);
        var registerPage = new RegisterPage(driver);
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
        LogOut();
    }

    @When("The user attempts to login with correct credentials")
    public void theUserAttemptsToLoginWithCorrectCredentials() {
        loginPage
                .setUsername(customer.getUsername())
                .setPassword(customer.getPassword())
                .clickLogin();
    }

    @Then("The site should login user successfully")
    public void theSiteShouldLoginUserSuccessfully() {
        boolean isAccountTableDisplayed = driver.findElement(By.id("accountTable")).isDisplayed();
        assertThat(isAccountTableDisplayed, is(true));
        String actualCurrentUrl = driver.getCurrentUrl();
        assertThat(actualCurrentUrl, equalTo("https://parabank.parasoft.com/parabank/overview.htm"));
    }

    @When("The user attempts to login with incorrect password")
    public void theUserAttemptsToLoginWithIncorrectPassword() {
        loginPage
                .setUsername(customer.getUsername())
                .setPassword(faker.internet().password())
                .clickLogin();
    }

    @Then("The site should not login user")
    public void theSiteShouldNotLoginUser() {
        String actualErrorText = driver.findElement(By.cssSelector(".error")).getText();
        assertThat(actualErrorText, equalTo("An internal error has occurred and has been logged."));
        String actualCurrentUrl = driver.getCurrentUrl();
        assertThat(actualCurrentUrl, equalTo("https://parabank.parasoft.com/parabank/login.htm"));
    }

    @After("@CustomerLogin")
    public void teardown() {
        LogOut();
        driver.quit();
    }

    private void LogOut() {

        var logOutLinks = driver.findElements(By.linkText("Log Out"));
        if (!logOutLinks.isEmpty()) {
            logOutLinks.get(0).click();
        }
    }
}
