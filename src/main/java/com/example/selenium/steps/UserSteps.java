package com.example.selenium.steps;

import com.example.selenium.pages.LoginPage;
import com.example.selenium.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserSteps {
    private WebDriver driver;

    public UserSteps(WebDriver driver) {
        this.driver = driver;
    }

    public com.example.selenium.steps.UserSteps login(String username, String password) {
        // TODO initialize LoginPage, call setUsername, setPassword, and click login methods
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUsername(username)
                .setPassword(password)
                .clickLogin();

        //  TODO assert title
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getTitle(), "Secure Area", "Login failed");
        return this;
    }

    public UserSteps logout() {
        // TODO call logout method
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogout();
        return this;
    }
}
