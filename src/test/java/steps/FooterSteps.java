package steps;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.HomePage;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterSteps {
    private WebDriver driver;
    private HomePage homePage;
    private String homePageUrl;

    @BeforeAll
    public static void before() {
        WebDriverManager.edgedriver().setup();
    }

    @Given("The Home page URL")
    public void theHomePageURL() {
        homePageUrl = "https://parabank.parasoft.com/parabank/register.htm";
    }

    @When("The user navigates to the URL")
    public void theUserNavigatesToTheURL() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(homePageUrl);
    }

    @Then("The Home page should have links displayed in the Footer section")
    public void theHomePageShouldHaveLinksDisplayedInTheFooterSection() {
        homePage = new HomePage(driver);
        var actual = homePage.GetFooterLinks();
        assertThat("There should be link(s) in the footer section.", actual.size(), is(not(equalTo(0))));
    }

    @After("@Footer")
    public void teardown() {
        driver.quit();
    }
}
