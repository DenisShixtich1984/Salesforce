package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Account;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.InputWithSuggestion;

public class NewAccountModal extends BasePage{

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

    public NewAccountModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public NewAccountModal openNewFieldsAccounts() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", buttonAccounts);
        isPageOpened();
        buttonNew.click();
        return this;
    }

    public void waiterVisibleNameAccount () {
        wait.until(ExpectedConditions.visibilityOf(checkAccount));
    }

    public void createNewAccount(String accountName,String phone, String fax, String website, String employees,
                       String annualRevenue, String parentAccount, String type,String industry, String shippingCity,
                                  String state, String zip, String country, String billingCity,
                            String province, String zipcode, String bildCout){
        new Input(driver,"Account Name").write(accountName);
        new Input(driver,"Phone").write(phone);
        new Input(driver,"Fax").write(fax);
        new Input(driver,"Website").write(website);
        new Input(driver,"Employees").write(employees);
        new Input(driver,"Annual Revenue").write(annualRevenue);
        new InputWithSuggestion(driver,"Parent Account").inputSuggestion(parentAccount);
        new DropDown(driver,"Type").select(type);
        new DropDown(driver,"Industry").select(industry);
        scroll();
        new Input(driver,"Shipping City").write(shippingCity);
        new Input(driver,"Shipping State/Province").write(state);
        new Input(driver,"Shipping Country").write(country);
        new Input(driver,"Shipping Zip/Postal Code").write(zip);
        new Input(driver,"Billing City").write(billingCity);
        new Input(driver,"Billing State/Province").write(province);
        new Input(driver,"Billing Zip/Postal Code").write(zipcode);
        new Input(driver,"Billing Country").write(bildCout);
    }

    public void createNewAccount (Account account) {

        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver,"Fax").write(account.getFax());
        new Input(driver,"Phone").write(account.getPhone());
        new Input(driver,"Account Name").write(account.getAccountName());
        new InputWithSuggestion(driver,"Parent Account").inputSuggestion(account.getParent());
        new Input(driver,"Employees").write(account.getEmployees());
        new Input(driver,"Annual Revenue").write(account.getAnnualrevenue());
        new DropDown(driver,"Type").select(account.getType());
        new DropDown(driver,"Industry").select(account.getIndustry());
    }

    public void scroll () {
        executor.executeScript("arguments[0].scrollIntoView()", scrollLocator);
    }

    public void save () {
        buttonSave.click();
    }

    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.urlToBe("https://ewavecommerce8.lightning.force.com/" +
                "lightning/o/Account/list?filterName=Recent"));
        return this;
    }
}
