package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TransferMoneyModal extends BasePage {

    @FindBy(xpath = "//div[.='Receiver account']/following-sibling::div[2]/select")
    private WebElement receiverAccountDropdown;

    @FindBy(xpath = "//div[.='Sender account']/following-sibling::div[2]/select")
    private WebElement senderAccountDropdown;

    @FindBy(tagName = "input")
    private WebElement amountInputBox;

    @FindBy(xpath = "//div[.='Send']")
    private WebElement sendButton;

    public void selectReceiverAccount(String account) {
        Select select = new Select(receiverAccountDropdown);
        select.selectByVisibleText(account);
    }

    public String getReceiverAccount() {
        Select select = new Select(receiverAccountDropdown);
        return getText(select.getFirstSelectedOption());
    }

    public void selectSenderAccount(String account) {
        Select select = new Select(senderAccountDropdown);
        select.selectByVisibleText(account);
    }

    public String getSenderAccountName() {
        Select select = new Select(senderAccountDropdown);
        return getText(select.getFirstSelectedOption());
    }

    public void enterAmount(String amount) {
        sendKeys(amountInputBox, amount);
    }

    public void submitTransfer() {
        click(sendButton);
    }

}
