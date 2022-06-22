package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.NewAccountModal;
import pages.NewContactModal;
import pages.Registration;
import steps.Steps;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected NewAccountModal newAccountModal;
    protected NewContactModal newContactModal;
    protected Registration registration;
    protected Faker faker;
    protected Steps steps;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("---------------Before Method--------------");
        newAccountModal = new NewAccountModal(driver);
        newContactModal = new NewContactModal(driver);
        registration = new Registration(driver);
        faker = new Faker();
        steps = new Steps(driver);
    }
    @AfterMethod
    public void closeBrowser () {
        driver.quit();
        System.out.println("---------------After Method--------------");
    }
}