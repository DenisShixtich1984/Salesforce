package tests;

import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    @Test
    public void testCreateAccounts() {
        registration.openStartPage();
        registration.registrationName();
        registration.isPageOpened();
    }
}
