package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage setUsername(String username){
        driver.findElement(By.name("username")).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password){
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public void clickLogin(){
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }
}
