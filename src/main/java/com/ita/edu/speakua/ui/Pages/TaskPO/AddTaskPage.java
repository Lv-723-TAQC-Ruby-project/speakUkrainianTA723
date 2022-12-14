package com.ita.edu.speakua.ui.Pages.TaskPO;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class AddTaskPage extends BasePageWithHeader {

    @FindBy(xpath = "//input[@id='startDate']")
    public WebElement startDate;

    @FindBy(xpath = "//input[@id='picture']")
    public WebElement uploadImage;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement taskName;

    @FindBy(xpath = "//div[contains(@class, 'ql-editor ql-blank')]")
    public WebElement taskTitle;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor ql-blank')])[1]")
    public WebElement taskDescription;

    @FindBy(xpath = "//input[@id='challengeId']")
    public WebElement chooseChallenge;

    @FindBy(xpath = "//div[contains(text(), 'New Challenge')]")
    public WebElement challenge;

    @FindBy(xpath = "//button[contains(@class, 'ant-btn ant-btn-primary flooded-button add-contact-type-button')]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='ant-message']")
    private WebElement errorMessage;

    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getStartDate() {
        return startDate;
    }

    public WebElement getUploadImage() {
        return uploadImage;
    }

    public WebElement getTaskName() {
        return taskName;
    }

    public WebElement getTaskTitle() {
        return taskTitle;
    }

    public WebElement getTaskDescription() {
        return taskDescription;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @Step
    public AddTaskPage enterStartDate(String date) {
        startDate.sendKeys(date, Keys.ENTER);
        return this;
    }

    @Step
    public AddTaskPage uploadImage(String image) {
        uploadImage.sendKeys(System.getProperty("user.dir")+image);
        return this;
    }

    @Step
    public AddTaskPage enterTaskName(String taskName) {
        this.taskName.sendKeys(taskName);
        return this;
    }

    @Step
    public AddTaskPage enterTaskTitle(String taskTitle) {
        this.taskTitle.sendKeys(taskTitle);
        return this;
    }

    @Step
    public AddTaskPage enterTaskDescription(String taskDescription) {
        this.taskDescription.sendKeys(taskDescription);
        return this;
    }

    public boolean isContainErrorMessage(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-message']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean successMessage(String names) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-message']", names)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step
    public AddTaskPage chooseChallenge() {
        chooseChallenge.click();
        challenge.click();
        return this;
    }

    @Step
    public AddTaskPage clickSave() {
        saveButton.click();
        sleep(3);
        return this;
    }
}
