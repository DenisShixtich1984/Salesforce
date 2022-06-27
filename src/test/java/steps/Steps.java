package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.NewAccountModal;
import pages.Registration;

public class Steps {
    private Registration registration;
    private NewAccountModal newAccountModal;

    public Steps (WebDriver driver) {
        registration = new Registration(driver);
        newAccountModal = new NewAccountModal(driver);
    }
        @Step()
        public Steps StartSteps () {
        registration
                .openStartPage()
                .registrationName();
        registration
                .isPageOpened();
            return this;
        }
}
