package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.Utilities;

public class TransferMoneyDefinition extends TestBase {

    double transferredAmount;
    String accountName;

    @When("check the total amount")
    public void check_the_total_amount() {
        totalAmount = moneyTransferPage.getAmount();
    }

    @And("check the account name")
    public void checkTheAccountName() {
        accountName = moneyTransferPage.getAccountName();
    }

    @And("user open money transfer modal")
    public void userOpenMoneyTransferModal() {
        moneyTransferPage.openTransferMoneyModal();
    }

    @When("user transferred {string}")
    public void user_transferred(String amount) {
        transferMoneyModal.enterAmount(amount);
        transferMoneyModal.submitTransfer();
        transferredAmount = Double.parseDouble(amount);
    }

    @Then("verify that total amount changed based on transferred amount")
    public void verify_that_total_amount_changed_based_on_transferred_amount() {
        //Added static wait to avoid flakiness
        Utilities.waitFor(1);
        Assert.assertEquals("Total amount is wrong!", (totalAmount - transferredAmount), moneyTransferPage.getAmount(), 0);
    }

    @Then("verify that transaction shows latest action as {string}")
    public void verify_that_transaction_shows_latest_action_as(String string) {
        Assert.assertEquals("Transaction amount is wrong!", transferredAmount, moneyTransferPage.getLatestTransactionAmount(), 0);
    }


    @And("user change the receiver account as {string}")
    public void userChangeTheReceiverAccountAs(String receiverName) {
        transferMoneyModal.selectReceiverAccount(receiverName);
    }

    @Then("verify that receiver account changed to {string}")
    public void verifyThatReceiverAccountChangedSuccessfully(String receiverName) {
        //Added static wait to avoid flakiness
        Utilities.waitFor(1);
        Assert.assertEquals("Receiver account name is not changed!", receiverName, transferMoneyModal.getReceiverAccount());
    }


    @Then("verify that sender account name is correct")
    public void verifyThatSenderAccountNameIsCorrect() {
        Assert.assertEquals("Account names are not matched!", accountName, transferMoneyModal.getSenderAccountName());
    }

    @Then("verify that total amount is not changed")
    public void verifyThatTotalAmountIsNotChanged() {
        //Added static wait to avoid flakiness
        Utilities.waitFor(1);
        Assert.assertEquals("Total amount is changed!", totalAmount, moneyTransferPage.getAmount(), 0);
    }

}
