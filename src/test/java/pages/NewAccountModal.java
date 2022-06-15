package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.InputWithSuggestion;

public class NewAccountModal extends BasePage{

    public NewAccountModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    @FindBy (xpath = "//a[@title='Accounts']")
    public WebElement buttonAccounts;
    @FindBy (xpath = "//div[@title='New']")
    public WebElement buttonNew;
    @FindBy (css = "[title='Save']")
    public WebElement buttonSave;
    @FindBy (xpath = "//span[text()='Copy Billing Address to Shipping Address']")
    public WebElement scrollLocator;
    @FindBy (xpath = "//lightning-formatted-text[text()='Skrizhali_music4']")
    public WebElement checkAccount;

    public NewAccountModal createAccounts() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", buttonAccounts);
        buttonNew.click();
        return this;
    }

    public void waiterVisibleNameAccount () {
        wait.until(ExpectedConditions.visibilityOf(checkAccount));
    }

    public void createPart1(String accountName,String phone, String fax, String website, String employees,
                       String annualRevenue, String parentAccount, String type,String industry){
        new Input(driver,"Account Name").write(accountName);
        new Input(driver,"Phone").write(phone);
        new Input(driver,"Fax").write(fax);
        new Input(driver,"Website").write(website);
        new Input(driver,"Employees").write(employees);
        new Input(driver,"Annual Revenue").write(annualRevenue);
        new InputWithSuggestion(driver,"Parent Account").inputSuggestion(parentAccount);
        new DropDown(driver,"Type").select(type);
        new DropDown(driver,"Industry").select(industry);
    }

    public void createPart2 (String shippingCity, String state, String zip, String country, String billingCity,
                             String province, String zipcode, String bildCout) {
        new Input(driver,"Shipping City").write(shippingCity);
        new Input(driver,"Shipping State/Province").write(state);
        new Input(driver,"Shipping Country").write(country);
        new Input(driver,"Shipping Zip/Postal Code").write(zip);
        new Input(driver,"Billing City").write(billingCity);
        new Input(driver,"Billing State/Province").write(province);
        new Input(driver,"Billing Zip/Postal Code").write(zipcode);
        new Input(driver,"Billing Country").write(bildCout);
    }

    public void scroll () {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()", scrollLocator);
    }

    public void save () {
        buttonSave.click();
    }

}
