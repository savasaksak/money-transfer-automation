package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(8));

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    public void sendKeys(WebElement element, String key) {
        waitForVisibility(element);
        element.sendKeys(key);
    }

    public String getPageTitle() {
        return Driver.get().getTitle();
    }

}
