package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.Calculator;
import utilities.Driver;

public class CalcStepDefinitions {

    WebElement multiply = Driver.getAppiumDriver().findElementById("com.google.android.calculator:id/op_mul");
    WebElement minus = Driver.getAppiumDriver().findElementById("com.google.android.calculator:id/op_sub");
    String result;
    Calculator calc = new Calculator();
    @Given("the user opens the calculator app")
    public void theUserOpensTheCalculatorApp() throws InterruptedException {
        Driver.getAppiumDriver().findElementByXPath("//android.widget.TextView[@content-desc='Calculator']").click();Thread.sleep(2000); }

    @When("the user adds {string} and {string} and get the sum")
    public void theUserAddsAndAndGetTheSum() throws InterruptedException {
        calc.num2.click();
        calc.num3.click();
        calc.plus.click();
        calc.num9.click();
        calc.num5.click();
        Thread.sleep(1000);
        calc.equals.click();
        result=Driver.getAppiumDriver().findElementById("com.google.android.calculator:id/result_final").getText();
    }

    @And("takes the square root of that sum")
    public void takesTheSquareRootOfThatSum() throws InterruptedException {
        WebElement squareRoot = Driver.getAppiumDriver().findElementByAccessibilityId("square root");
        squareRoot.click();
        for (int i = 0; i < result.length(); i++) {
            switch (result.charAt(i)) {
                case '1':
                    calc.num1.click();
                    break;
                case '8':
                    calc.num8.click();
                    break;
            }
        }
        calc.equals.click();
        Thread.sleep(1000);
        result = Driver.getAppiumDriver().findElementById("com.google.android.calculator:id/result_final").getText();
        System.out.println("result after squareroot: " + result);
//        multiply.click();
//        minus.click();
//        Thread.sleep(1000);
//        calc.num1.click();
//        calc.equals.click();
//        Thread.sleep(1000);
//        result = Driver.getAppiumDriver().findElementById("com.google.android.calculator:id/result_final").getText();
//
    }

        @And("multiply it by {string}")
    public void multiplyItBy() throws InterruptedException {

        multiply.click();
        minus.click();
        calc.num1.click();
        calc.equals.click();
            Thread.sleep(1000);
        result = Driver.getAppiumDriver().findElementById("com.google.android.calculator:id/result_final").getText();
        System.out.println("Result after multiply by -1: " + result);
    }

    @And("verify the result")
    public void verifyTheResult() {
        String expectedResult = "-10.86278278049120021572389149933747374";
        Assert.assertEquals(result, expectedResult);
        String roundedExpectedResult = "10.8628";
        result = result.substring(1);
        Double doubleResult = Double.valueOf(result);
        System.out.println(doubleResult);
        double roundedResult = Math.round(doubleResult * 10000.0) / 10000.0;
        System.out.println(roundedResult);
        Assert.assertEquals(doubleResult, roundedExpectedResult);
    }
}
