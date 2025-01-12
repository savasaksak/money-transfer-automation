package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoneyTransferPage extends BasePage {

    @FindBy(xpath = "//div[.='Transfer money']")
    private WebElement transferMoneyButton;

    @FindBy(xpath = "//div[.='Add money']")
    private WebElement addMoneyButton;

    @FindBy(xpath = "//div[.='Edit account']")
    private WebElement editAccountButton;

    @FindBy(xpath = "//div[.='Account name']/following-sibling::div[1]")
    private WebElement accountName;

    @FindBy(xpath = "//div[.='Account type']/following-sibling::div[1]")
    private WebElement accountType;

    @FindBy(xpath = "//div[.='Amount']/following-sibling::div[1]")
    private WebElement amount;

    @FindBy(xpath = "//div[.='Amount: ']/following-sibling::div[1]")
    private WebElement latestTransactionAmount;

    public String getAccountName() {
        return getText(accountName);
    }

    public String getAccountType() {
        return getText(accountType);
    }

    public double getAmount() {
        String cleanedString = getText(amount).replaceAll("[^\\d.]", "");
        return Double.parseDouble(cleanedString);
    }

    public void openTransferMoneyModal() {
        click(transferMoneyButton);
    }

    public void openAddMoneyModal() {
        click(addMoneyButton);
    }

    public void openEditAccountModal() {
        click(editAccountButton);
    }

    public int getLatestTransactionAmount() {
        return Integer.parseInt(getText(latestTransactionAmount));
    }
}
