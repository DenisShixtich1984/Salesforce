package wrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputWithSuggestion {
    WebDriver driver;
    String label;

    public InputWithSuggestion(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    public void inputSuggestion (String text) {
        driver.findElement(By.xpath(String.format("//span[text()='Parent Account']" +
                "/ancestor::div[contains(@class, 'uiInput')]//input",label))).click();
        driver.findElement(By.xpath(String.format("//div[text()='<Skrizhali> LTD']",text))).click();
    }

}
