package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.Calculator;
import utilities.Driver;

public class CalcStepDefinitions {
    String result;
    Calculator calc = new Calculator();
    @Given("the user opens the calculator app")
    public void theUserOpensTheCalculatorApp() {
        Driver.getAppiumDriver().findElementByXPath("//android.widget.TextView[@content-desc='Calculator']").click(); }

    @When("the user adds {string} and {string} and get the sum")
    public void theUserAddsAndAndGetTheSum(String arg0, String arg1) {
        calc.num2.click();
        calc.num3.click();
        calc.plus.click();
        calc.num9.click();
        calc.num5.click();
        calc.equals.click();
    }

    @And("takes the square root of that sum")
    public void takesTheSquareRootOfThatSum() {
        calc.squareRoot.click();
        calc.equals.click();
        String result = Driver.getAppiumDriver().findElementById("com.google.android.calculator:id/result_final").getText();
        System.out.println("Result after square root: "+result);
    }

    @And("multiply it by {string}")
    public void multiplyItBy(String arg0) {
        calc.multiply.click();
        calc.minus.click();
        calc.num1.click();
        calc.equals.click();
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
