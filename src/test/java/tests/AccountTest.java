package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
    @Test
    public void testCreateAccounts() {
        registration.openStartPage();
        registration.registrationName();
        registration.isPageOpened();
        newAccountModal.createAccounts();
        newAccountModal.createPart1("Skrizhali_music4", "+375298455696", "3765655474",
                "https://open.spotify.com/", "996", "508799",
                "<Skrizhali> IT", "Competitor", "Communications");
        newAccountModal.scroll();
        newAccountModal.createPart2("55789", "first2", "88557", "Rusland", "simple1",
                "text2", "113", "Japan");
        newAccountModal.save();
        newAccountModal.waiterVisibleNameAccount();
        Assert.assertTrue(newAccountModal.checkAccount.isEnabled());
        Assert.assertEquals(newAccountModal.checkAccount.getText(),"Skrizhali_music4");
    }
}