package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(css = "[placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[text()='Username or Password Invalid!']")
    private WebElement errorMessage;

    public void login(String username, String password) {
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
