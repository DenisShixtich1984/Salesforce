package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wrappers.Input;
import wrappers.DropDown;

public class NewContactModal extends BasePage{

    public NewContactModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    @FindBy(xpath = "//span[text() ='Contacts']")
    public WebElement buttonContacts;
    @FindBy (xpath = "//div[@title='New']")
    public WebElement buttonNew1;
    @FindBy (xpath = "//span[text()='Address Information']")
    public WebElement locatorAddress;
    @FindBy (xpath = "//span[text()='Description Information']")
    public WebElement locatorDescriptionInformation;
    @FindBy (xpath = "//button[text()='Save']")
    public WebElement buttonSave;
    @FindBy (xpath = "//lightning-formatted-name")
    public WebElement contactName;

    public NewContactModal createContact() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",buttonContacts);
        buttonNew1.click();
            return this;
    }

    public void createContactPart1(String phone,String mobile,String email, String firstName,String lastname,
                                   String title, String accountName) {
        new Input(driver, "Phone").writeContacts(phone);
        new Input(driver, "Mobile").writeContacts(mobile);
        new Input(driver, "Email").writeContacts(email);
        new Input(driver, "First Name").writeContacts(firstName);
        new Input(driver, "Last Name").writeContactsForLastName(lastname);
        new Input(driver, "Title").writeContacts(title);
        new DropDown(driver,"Account Name").selectContact(accountName);
    }

    public void scrollContact() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()",locatorAddress);
    }

    public void createContactPart2(String mailingCity,String fax, String otherCity, String homePhone, String department) {
        new Input(driver, "Mailing City").writeContacts(mailingCity);
        new Input(driver, "Fax").writeContacts(fax);
        new Input(driver,"Other City").writeContacts(otherCity);
        new Input(driver,"Home Phone").writeContacts(homePhone);
        new Input(driver,"Department").writeContacts(department);
    }

    public void scrollContact2() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()",locatorDescriptionInformation);
    }

    public void createContactPart3 (String otherPhone, String birthdate, String asst, String assistant) {
        new Input(driver, "Other Phone").writeContacts(otherPhone);
        new Input(driver, "Birthdate").writeContacts(birthdate);
        new Input(driver, "Asst. Phone").writeContacts(asst);
        new Input(driver, "Assistant").writeContacts(assistant);
    }
}
