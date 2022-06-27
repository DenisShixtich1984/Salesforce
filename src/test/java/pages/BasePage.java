package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected JavascriptExecutor executor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(13));
        this.executor = (JavascriptExecutor) driver;
    }
    public  abstract BasePage isPageOpened ();
    protected WebDriverWait wait;
}
