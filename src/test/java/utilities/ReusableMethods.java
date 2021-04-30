package utilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ReusableMethods {
    public static void goToPage(String pageName){
        List<WebElement> pages = Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView");
        if(pages.size()>0) {
            for (WebElement page : pages) {
                if (page.getText().equals(pageName)) {
                    page.click();
                    break;
                }
            }
        }else{
            scrollToText(pageName);
        }
    }

    /**
     *
     * @param element
     * @return
     */
    public static WebElement waitFotVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(),15);
        return  wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(),15);
        return  wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * UiScrollable
     * @param text
     */

    public static void scrollToText(String text){
        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");

        driver.findElementByXPath("//android.widget.TextView[@text='"+text+"']").click();

    }


}
