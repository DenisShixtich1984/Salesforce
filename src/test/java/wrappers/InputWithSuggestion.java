package wrappers;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class InputWithSuggestion extends BaseWrapper{

    public InputWithSuggestion(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    public void inputSuggestion (String text) {
        log.info("Wrapper inputSuggestion for {} ",text);
        driver.findElement(By.xpath(String.format("//span[text()='Parent Account']" +
                "/ancestor::div[contains(@class, 'uiInput')]//input",label))).click();
        driver.findElement(By.xpath(String.format("//div[text()='<Skrizhali> LTD']",text))).click();
    }

}
