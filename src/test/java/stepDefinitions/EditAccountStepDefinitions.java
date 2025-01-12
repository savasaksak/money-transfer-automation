package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EditAccountModal;
import utils.Utilities;

public class EditAccountStepDefinitions extends TestBase {

    EditAccountModal editAccountModal = new EditAccountModal();

    @When("user edit account modal")
    public void user_edit_account_modal() {
        moneyTransferPage.openEditAccountModal();
    }

    @When("user change account name with {string}")
    public void user_change_account_name_with(String accountName) {
        editAccountModal.enterAccountName(accountName);
        Utilities.waitFor(1);
        editAccountModal.updateAccountName();

    }

    @Then("verify that account name updated as {string}")
    public void verify_that_account_name_updated_as(String newAccountName) {
        //Added static wait to avoid flakiness
        Utilities.waitFor(1);
        Assert.assertEquals("Account name is not updated!", newAccountName, moneyTransferPage.getAccountName());
    }
}
