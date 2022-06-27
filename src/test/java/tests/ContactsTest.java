package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest{

    @Test
    public void testCreateContact () {
        registration.openStartPage();
        registration.registrationName();
        registration.isPageOpened();
        newContactModal.openNewFieldContact();
        newContactModal.createContact("80283745984","+37529564785","dertrog@mail.ru",
                "Victor","Ivanov", "title1","Account Name2","Minsk citi",
                "8758485", "Grodno2", "80226346758",
                "new Department2","6575846738", "6/15/2001", "357357334",
                "Pike");
        newContactModal.buttonSave.click();
        Assert.assertEquals(newContactModal.contactName.getText(),"Victor Ivanov");
    }
}
