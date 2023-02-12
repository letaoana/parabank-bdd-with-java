package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BalancePage {
    private WebDriver driver;

    public BalancePage(WebDriver driver){
        this.driver = driver;
    }

    private void SetUsername(String username){
        driver.findElement(By.name("username")).sendKeys(username);
    }

    private void SetPassword(String password){
        driver.findElement(By.name("password")).sendKeys(password);
    }

    private void ClickLoginButton(){
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    public void Login(String username, String password){
        SetUsername(username);
        SetPassword(password);
        ClickLoginButton();
    }

}
