package com.ita.edu.speakua.ui.profilemenu;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.AddClubModel;
import com.ita.edu.speakua.ui.ProfilePO.MyProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfileMenu extends BasePO {

    @FindBy(xpath = "//div[contains(text(), 'Додати гурток')]")
    private WebElement addClubButton;

    @FindBy(xpath = "//div[contains(text(), 'Додати центр')]")
    private WebElement addCenterButton;

    @FindBy(xpath = "//div[contains(text(), 'Пошук сертифікатів')]")
    private WebElement searchCertificatesButton;

    @FindBy(xpath = "//a[contains(text(), 'Мій Профіль')]")
    private WebElement myProfileButton;


    @FindBy(xpath = "//span[contains(text(), 'Вийти')]")
    private WebElement quitButton;

    public UserProfileMenu(WebDriver driver) {
        super(driver);
    }

    public AddClubModel openAddClubModel() {
        addClubButton.click();
         return new AddClubModel(driver);
    }

    public void openAddCenterModel() {
        addCenterButton.click();
        // return new AddCenterModel(driver);
    }

    public MyProfilePage openMyProfileModel(){
        myProfileButton.click();
        return new MyProfilePage(driver);
    }



}