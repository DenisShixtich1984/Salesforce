package wrappers;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class Input extends BaseWrapper{

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info("Wrapper input for {} ",text);
        if (text != null) {
            driver.findElement(By.xpath(
                            String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input", label)))
                    .sendKeys(text);
        }
    }

    public void writeContacts(String text) {
        log.info("Wrapper input write Contact for {} ",text);
        if (text != null) {
            driver.findElement(By.xpath(
                            String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]//input", label)))
                    .sendKeys(text);
        }
    }

    public void writeContactsForLastName(String text) {
        log.info("Wrapper input Contact for {} ",text);
        if (text != null) {
            driver.findElement(By.xpath(
                    String.format("//label[text()='Last Name']/ancestor::div[contains(@class, 'slds-grid')]" +
                            "//input[@aria-invalid='true']", label))).sendKeys(text);
        }
    }
}
