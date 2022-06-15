package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Registration extends BasePage{
    public Registration(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement userName;
    @FindBy (id = "password" )
    public WebElement passWord;
    @FindBy (id = "Login")
    public WebElement login;
    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.urlToBe("https://ewavecommerce8.lightning.force.com/lightning/page/home"));
        return this;
    }

    public void openStartPage () { driver.get("https://ewavecommerce8.my.salesforce.com"); }

    public NewAccountModal registrationName () {
        userName.sendKeys("denis-shlyakhticev-d710@force.com");
        passWord.sendKeys("SKRIZHALI2001");
        login.click();
        return new NewAccountModal(driver);
    }
}
