package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;
import utils.Utilities;

import java.time.Duration;

public class Hooks {
    @Before
    public void setUp() {
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown(Scenario scenario) {
        //Adds screenshot to the report on the failed step
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.get();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_step_image");
        }
        Utilities.waitFor(1);
        Driver.closeDriver();
    }
}
