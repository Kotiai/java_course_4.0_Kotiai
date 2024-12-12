package com.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // TODO define username, password, and login WebElements using @FindBy
    @FindBy(id = "username")
    @CacheLookup
    WebElement username;

    @FindBy(id = "password")
    @CacheLookup
    WebElement password;

    @FindBy(css = ".fa")
    @CacheLookup
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUsername(String text) {
        // TODO set username
        username.sendKeys(text);
        return this;
    }

    public LoginPage setPassword(String text) {
        // TODO set password
        password.sendKeys(text);
        return this;
    }

    public MainPage clickLogin() {
        // TODO click logout return instance of MainPage
        loginButton.click();
        return new MainPage(driver);
    }
}
