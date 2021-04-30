package page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.time.Duration;

public class Calculator {
    public Calculator() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)),this);
    }

    @AndroidFindBy(id ="com.google.android.calculator:id/digit_1" )
    public WebElement num1;
    @AndroidFindBy(id ="com.google.android.calculator:id/digit_2")
    public WebElement num2;
    @AndroidFindBy(id ="com.google.android.calculator:id/digit_3")
    public WebElement num3;
    @AndroidFindBy(id ="com.google.android.calculator:id/digit_5")
    public WebElement num5;
    @AndroidFindBy(id ="com.google.android.calculator:id/digit_8")
    public WebElement num8;
    @AndroidFindBy(id ="com.google.android.calculator:id/digit_9")
    public WebElement num9;
    @AndroidFindBy(id ="plus")
    public WebElement plus;
    @AndroidFindBy(id ="equals")
    public WebElement equals;

}
