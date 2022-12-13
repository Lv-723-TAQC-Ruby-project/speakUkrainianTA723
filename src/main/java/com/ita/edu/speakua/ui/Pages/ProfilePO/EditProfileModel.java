package com.ita.edu.speakua.ui.Pages.ProfilePO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfileModel extends BasePO {

    @FindBy(xpath = "//input[@id='edit_lastName']")
    private WebElement editLastNameField;

    @FindBy(xpath = "//input[@id='edit_phone']")
    private WebElement editNumberPhoneField;

    @FindBy(xpath = "//*[@id=\"edit_currentPassword\"]")
    private WebElement enterCurrentPasswordField;

    @FindBy(xpath = "//*[@id=\"edit_password\"]")
    private WebElement getEnterNewPasswordField;

    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[10]/button")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//div[@class='ant-form-item-explain-error']")
    private WebElement messageAboutIncorrectlyEnteredLastName;

    @FindBy(xpath = "//div[2]/div[7]/div/input")
    private  WebElement changePasswordCheckBox;

    public EditProfileModel(WebDriver driver) {
        super(driver);
    }
    public EditProfileModel clickChangePasswordCheckBox() {
        changePasswordCheckBox.click();
        return this;
    }

    public boolean isOpenMassageErrorLastNameContain(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-form-item-explain-error']",  name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOpenMassageErrorPhoneContain(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-form-item-explain-error']",  name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public EditProfileModel EnterLastName(String lastName){
        editLastNameField.sendKeys(Keys.DELETE);
        sleep(1);
        editLastNameField.sendKeys(lastName);
        sleep(2);
        return this;
    }
    public EditProfileModel DeleteLastName(){
        editLastNameField.sendKeys(Keys.DELETE);
        return this;
    }

    public EditProfileModel EnterNumberPhone(String numberPhone ){
        editNumberPhoneField.sendKeys(Keys.DELETE);
        sleep(1);
       editNumberPhoneField.sendKeys(numberPhone);
        sleep(2);
        return this;
    }

    public EditProfileModel DeleteNumberPhone(){
        editNumberPhoneField.sendKeys(Keys.DELETE);
        return this;
    }
}
