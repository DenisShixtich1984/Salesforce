package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.Steps;
import utils.Account;


public class AccountTest extends BaseTest {
    // тест без использования фэйкера и билдера
    @Test
    public void testCreateAccounts() {
        registration.openStartPage();
        registration.registrationName();
        registration.isPageOpened();
        newAccountModal.openNewFieldsAccounts();
        newAccountModal.createNewAccount("Skrizhali_music4", "+375298455696", "3765655474",
                "https://open.spotify.com/", "996", "508799",
                "<Skrizhali> IT", "Competitor", "Communications", "55789",
                "first2", "88557", "Rusland", "simple1",
                "text2", "113", "Japan");
        newAccountModal.save();
        newAccountModal.waiterVisibleNameAccount();
        Assert.assertTrue(newAccountModal.checkAccount.isEnabled());
        Assert.assertEquals(newAccountModal.checkAccount.getText(), "Skrizhali_music4");

    }
// ест с использованием билдераб фэйкера и степа
    @Test
    public void testCreateAccountWithFaker() {

        steps.StartSteps();

        newAccountModal.openNewFieldsAccounts();

        Account account = Account.builder()
                .website(faker.twinPeaks().character())
                .fax(faker.phoneNumber().phoneNumber())
                .accountName(faker.name().fullName())
                .phone(faker.phoneNumber().cellPhone())
                .parent("<Skrizhali> IT")
                .employees(String.valueOf(faker.number().numberBetween(100, 500)))
                .annualrevenue(faker.finance().iban())
                .industry("Communications")
                .type("Competitor")
                .build();
        newAccountModal.createNewAccount(account);
        newAccountModal.save();
    }
}