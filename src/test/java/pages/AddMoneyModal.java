package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;
import utils.Utilities;

import java.util.List;

public class AddMoneyModal extends BasePage {

    @FindBy(xpath = "//div[.='Card number']/following-sibling::input[1]")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//div[.='Card holder']/following-sibling::input[1]")
    private WebElement cardHolderInput;

    @FindBy(xpath = "//div[.='Expiry date']/following-sibling::input[1]")
    private WebElement expiryDateInput;

    @FindBy(xpath = "//div[.='CVV']/following-sibling::input[1]")
    private WebElement cvvInput;

    @FindBy(xpath = "//div[.='Amount']/following-sibling::input[1]")
    private WebElement amountInput;

    @FindBy(xpath = "//div[.='Add']")
    private WebElement addMoneyButton;

    @FindBy(xpath = "//div[.='Required']")
    private List<WebElement> errorMessage;

    @FindBy(xpath = "//div[.='Expiry date']/following-sibling::div[1]")
    private WebElement expiryDateErrorMessage;

    @FindBy(xpath = "//div[.='Card holder']/following-sibling::div[1]")
    private WebElement cardHolderErrorMessage;


    public void enterCardNumber(String cardNumber) {
        sendKeys(cardNumberInput, cardNumber);
    }

    public void enterCardHolder(String cardHolder) {
        sendKeys(cardHolderInput, cardHolder);
    }

    public void enterExpiryDate(String expiryDate) {
        sendKeys(expiryDateInput, expiryDate);
    }

    public void enterCVV(String cvv) {
        sendKeys(cvvInput, cvv);
    }

    public void enterAmount(String amount) {
        sendKeys(amountInput, amount);
    }

    public void addMoney() {
        click(addMoneyButton);
    }

    public void enterValidCardCredentials() {
        enterCardNumber(ConfigReader.get("cardNumber"));
        enterCardHolder("test" + Utilities.generateTimestamp());
        enterExpiryDate(ConfigReader.get("expiryDate"));
        enterCVV(ConfigReader.get("cvv"));
    }

    public boolean areAllFieldRequired() {
        return errorMessage.size() == 5;
    }

    public String getErrorMessage() {
        return getText(errorMessage.get(0));
    }

    public boolean isCardHolderEnabled() {
        return cardHolderInput.isEnabled();
    }

    public String getExpiryDateErrorMessage() {
        return getText(expiryDateErrorMessage);
    }

    public String getCardHolderErrorMessage() {
        return getText(cardHolderErrorMessage);
    }
}
