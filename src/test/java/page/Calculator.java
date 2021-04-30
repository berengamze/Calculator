package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.net.URL;
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
    @AndroidFindBy(id ="com.google.android.calculator:id/op_mul")
    public WebElement multiply;
    @AndroidBy(id ="com.google.android.calculator:id/op_sub")
    public WebElement minus;
    @AndroidFindBy(id ="right parenthesis")
    public WebElement rightParanthesis;
    @AndroidFindBy(id ="left parenthesis")
    public WebElement leftParanthesis;
    @AndroidFindBy(id ="plus")
    public WebElement plus;
    @AndroidFindBy(id ="equals")
    public WebElement equals;
    @AndroidFindBy(id ="square root")
    public WebElement squareRoot;

}
