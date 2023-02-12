package pages;

import constants.FieldIdentifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public RegisterPage setFirstName(String firstName){ driver.findElement(By.id(FieldIdentifier.FIRST_NAME_ID)).sendKeys(firstName);
    return this;
    }

    public RegisterPage setLastName(String lastName){
        driver.findElement(By.id(FieldIdentifier.LAST_NAME_ID)).sendKeys(lastName);
        return this;
    }

    public RegisterPage setAddress(String address){
        driver.findElement(By.id(FieldIdentifier.ADDRESS_ID)).sendKeys(address);
        return this;
    }

    public RegisterPage setCity(String city){
        driver.findElement(By.id(FieldIdentifier.CITY_ID)).sendKeys(city);
        return this;
    }

    public RegisterPage setState(String state){
        driver.findElement(By.id(FieldIdentifier.STATE_ID)).sendKeys(state);
        return this;
    }

    public RegisterPage setZipCode(String zipCode){
        driver.findElement(By.id(FieldIdentifier.ZIPCODE_ID)).sendKeys(zipCode);
        return this;
    }

    public RegisterPage setSsn(String ssn){
        driver.findElement(By.id(FieldIdentifier.SSN_ID)).sendKeys(ssn);
        return this;
    }

    public RegisterPage setUsername(String username){
        driver.findElement(By.id(FieldIdentifier.USERNAME_ID)).sendKeys(username);
        return this;
    }

    public RegisterPage setPassword(String password){
        driver.findElement(By.id(FieldIdentifier.PASSWORD_ID)).sendKeys(password);
        return this;
    }

    public RegisterPage setConfirm(String password){
        driver.findElement(By.id(FieldIdentifier.CONFIRM_ID)).sendKeys(password);
        return this;
    }

    public String GetFormInputFieldError(String fieldName){
        String id = String.format("%s.errors", fieldName);
        return driver.findElement(By.id(id)).getText();
    }

    public RegisterPage clickRegisterButton(){
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        return this;
    }

}
