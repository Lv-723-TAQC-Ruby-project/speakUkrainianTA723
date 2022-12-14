package com.ita.edu.speakua.ui.profilemenu;


import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.CenterPO.AddCenterModal;
import com.ita.edu.speakua.ui.Pages.ClubsPO.AddClubModal;
import com.ita.edu.speakua.ui.Pages.ProfilePO.MyProfilePage;
import io.qameta.allure.Step;
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

    @FindBy(xpath = "//a[contains(text(), 'Особистий кабінет')]")
    private WebElement myProfileButton;

    @FindBy(xpath = "//span[contains(text(), 'Вийти')]")
    private WebElement quitButton;

    public UserProfileMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Open add club modal")
    public AddClubModal openAddClubModal() {
        wait.visibility(addClubButton);
        addClubButton.click();
        return new AddClubModal(driver);
    }

    @Step("Open add center modal")
    public AddCenterModal openAddCenterModal() {
        wait.visibility(addCenterButton);
        action.click(addCenterButton);
        return new AddCenterModal(driver);
    }

    @Step("Open my profile modal")
    public MyProfilePage openMyProfileModal() {
        wait.visibility(myProfileButton);
        myProfileButton.click();
        return new MyProfilePage(driver);
    }


}
