package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.HomePage;
import com.ita.edu.speakua.ui.Pages.CenterPO.AddLocationModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class AddClubModal extends BasePO {

    @FindBy(xpath = "//input[@id= 'basic_name']")
    private WebElement nameClubInput;

    @FindBy(xpath = "//input[@id= 'basic_ageFrom']")
    private WebElement ageFromInput;

    @FindBy(xpath = "//input[@id= 'basic_ageTo']")
    private WebElement ageToInput;

    @FindBy(xpath = "//span[@class='add-club-location']")
    WebElement addLocationButton;

    @FindBy(xpath = "//input[@id= 'basic_contactТелефон']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//button[contains(@class, 'add-club-content-next')]")
    private WebElement nextStepButton;

    @FindBy(id = "basic_description")
    private WebElement clubDescriptionInput;

    @FindBy(id = "basic_description_help")
    private WebElement errorMessage;

    @FindBy(css = ".anticon-check-circle")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(@class, 'ant-form-item-explain-error')]")
    private WebElement languageErrorMessage;

    @FindBy(xpath = "//div[contains(@class, 'ant-form-item-explain-error')]")
    private WebElement inappropriateDescriptionLengthMessage;

    @FindBy(xpath = "//input[@id=\"basic_centerId\"][@type='search']")
    private WebElement enterBelongingCenterInput;

    @FindBy(xpath = "//*[text()= 'Завершити']")
    private WebElement completeButton;

    public AddClubModal(WebDriver driver) {
        super(driver);
    }

    public AddClubModal selectCategoryByName(String categoryName) {
        driver.findElement(xpath(format("//span[text()='%s']//parent::label//input", categoryName))).click();
        return this;
    }

    public AddClubModal EnterNameClub(String nameClub) {
        nameClubInput.sendKeys(nameClub);
        return this;
    }

    public AddClubModal enterFromAge(String ageFrom) {
        ageFromInput.sendKeys(ageFrom);
        return this;
    }

    public AddClubModal enterToAge(String ageTo) {
        ageToInput.sendKeys(ageTo);
        return this;
    }

    public AddLocationModal clickAddLocationButton() {
        addLocationButton.click();
        return new AddLocationModal(driver);
    }

    public AddClubModal enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public AddClubModal clickNextStep() {
        nextStepButton.click();
        return new AddClubModal(driver);
    }

    public AddClubModal enterClubDescription(String clubDescription) {
        clubDescriptionInput.clear();
        clubDescriptionInput.sendKeys(clubDescription);
        return this;
    }

    public boolean successMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public boolean isErrorMessageDisplayed(String errorMessage) {
        wait.visibility(xpath(format("//div[text()='%s']", errorMessage)));
        return driver.findElement(xpath(format("//div[text()='%s']", errorMessage))).isDisplayed();
    }

    public AddClubModal enterBelongingToCenter(String nameCenter) {
        enterBelongingCenterInput.sendKeys(nameCenter);
        return this;
    }

    public HomePage finishAddingCenter() {
        completeButton.click();
        return new HomePage(driver);
    }

    public boolean completeButtonEnabled() {
        return completeButton.isEnabled();
    }
}