package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.ConfigReader;
import utils.Driver;
import utils.Utilities;

public class LoginStepDefinition extends TestBase {

    @Given("user navigates to catchylab login page")
    public void user_navigates_to_catchylab_login_page() {
        Driver.get().get(ConfigReader.get("baseUrl"));
    }

    @When("user logged in with valid credentials")
    public void user_loggin_page() {
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Utilities.waitFor(2);
    }

    @Then("verify that user on the home page")
    public void verify_that_user_on_the_home_page() {
        Assert.assertEquals(homePage.getPageTitle(), "apps");
    }

    @When("user navigates money transfer page")
    public void user_navigates_money_transfer_page() {
        homePage.openMoneyTransferPage();
    }

    @When("user logged in with {string} and {string}")
    public void userLoggedInWithAnd(String username, String password) {
        if (username.equals("validusername")) {
            username = ConfigReader.get("username");
        }
        if (password.equals("validpassword")) {
            password = ConfigReader.get("password");
        }
        loginPage.login(username, password);
    }

    @Then("verify that error message is {string}")
    public void verifyThatErrorMessageIs(String errorMessage) {
        Assert.assertEquals("Error message is wrong!", errorMessage, loginPage.getErrorMessage());
    }
}
