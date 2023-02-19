package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> GetFooterLinks(){

        var elements = driver.findElement(By.id("footerPanel")).findElements(new ByChained(By.tagName("ul"), By.tagName("li")));
        return elements;
    }
}
