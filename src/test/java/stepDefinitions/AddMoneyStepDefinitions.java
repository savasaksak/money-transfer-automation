package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import utils.Utilities;

public class AddMoneyStepDefinitions extends TestBase {

    Double addedAmount;

    @When("user open add money modal")
    public void user_open_add_money_modal() {
        moneyTransferPage.openAddMoneyModal();
    }

    @When("user add {string} to account")
    public void user_add_to_account(String amount) {
        addMoneyModal.enterValidCardCredentials();
        addMoneyModal.enterAmount(amount);
        addMoneyModal.addMoney();
        addedAmount = Double.parseDouble(amount);
    }

    @Then("verify that total amount changed based on added amount")
    public void verify_that_total_amount_changed_based_on_added_amount() {
        //Added static wait to avoid flakiness
        Utilities.waitFor(1);
        Assert.assertEquals("Total amount is wrong!", totalAmount + addedAmount, moneyTransferPage.getAmount(), 0);
    }

    @And("user enter card number as {string}")
    public void userEnterCardNumberAs(String cardNumber) {
        addMoneyModal.enterCardNumber(cardNumber);
    }

    @And("user enter long card number as {string}")
    public void userEnterLongCardNumberAs(String cardNumber) {
        addMoneyModal.enterCardNumber(cardNumber);
    }

    @Then("verify user can enter card holder name")
    public void verifyUserCanEnterCardHolderName() {
        Assert.assertTrue("Card Holder input field is not enabled!", addMoneyModal.isCardHolderEnabled());
    }

    @And("user enter expiry date as {string}")
    public void userEnterExpiryDateAs(String expiryDate) {
        addMoneyModal.enterExpiryDate(expiryDate + Keys.ENTER);
    }

    @Then("verify expiry date error message is {string}")
    public void verifyErrorMessageIs(String errorMessage) {
        Assert.assertEquals("Error message is wrong!", errorMessage, addMoneyModal.getExpiryDateErrorMessage());
    }

    @And("user enter short card holder name as {string}")
    public void userEnterShortCardHolderNameAs(String cardHolderName) {
        addMoneyModal.enterCardHolder(cardHolderName + Keys.ENTER);
    }

    @Then("verify card holder error message is {string}")
    public void verifyCardHolderErrorMessageIs(String errorMessage) {
        Assert.assertEquals(errorMessage, addMoneyModal.getCardHolderErrorMessage());
    }

    @And("user attempt to add money without credentials")
    public void userAttemptToAddMoneyWithoutCredentials() {
        addMoneyModal.addMoney();
    }

    @Then("verify card all fields have {string} error message")
    public void verifyCardAllFieldsHaveErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, addMoneyModal.getErrorMessage());
        Assert.assertTrue(addMoneyModal.areAllFieldRequired());
    }
}
