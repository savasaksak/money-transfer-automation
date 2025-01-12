package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[text()='Open Money Transfer']")
    private WebElement openMoneyTransferButton;

    public void openMoneyTransferPage() {
        click(openMoneyTransferButton);
    }
}
