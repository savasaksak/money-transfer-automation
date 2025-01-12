package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountModal extends BasePage {

    @FindBy(tagName = "input")
    private WebElement accountNameInput;

    @FindBy(xpath = "//div[.='UPDATE']")
    private WebElement updateButton;

    public void enterAccountName(String accountName) {
        accountNameInput.clear();
        sendKeys(accountNameInput, accountName);
    }

    public void updateAccountName() {
        click(updateButton);
    }

}
