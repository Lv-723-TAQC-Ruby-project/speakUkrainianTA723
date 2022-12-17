package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterModel extends BasePO {

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='confirm']")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//button[contains(@class, 'registration-button')]")
    private WebElement registerButton;

    @FindBy(xpath = "//button[contains(@class, 'ant-modal-close')]")
    private WebElement closeButton;

    public RegisterModel(WebDriver driver) {
        super(driver);
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getPhoneInput() {
        return phoneInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getPasswordConfirmInput() {
        return passwordConfirmInput;
    }

    public RegisterModel enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterModel enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterModel enterPhone(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    public RegisterModel enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public RegisterModel enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterModel enterPasswordConfirm(String passwordConfirm) {
        passwordConfirmInput.sendKeys(passwordConfirm);
        return this;
    }

    public HomePage clickRegister() {
        registerButton.click();
        sleep(3);
        return new HomePage(driver);

    }

    public HomePage cancelRegistration() {
        closeButton.click();
        sleep(3);
        return new HomePage(driver);

    }
}
