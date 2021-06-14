package stepDefinitionImplementation.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionsUtil;

import java.util.Arrays;

public class CheckoutImpl extends ActionsUtil {
    @CacheLookup
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']/span")
    private WebElement secondProceedCheckout;

    @CacheLookup
    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']/span")
    private WebElement thirdProceedCheckout;

    @CacheLookup
    @FindBy(xpath = "//button[@class='button btn btn-default standard-checkout button-medium']/span")
    private WebElement fourthProceedCheckout;

    @CacheLookup
    @FindBy(name = "cgv")
    private WebElement termsAndConditions;

    @CacheLookup
    @FindBy(css = "[class='bankwire']")
    private WebElement bankWire;

    @CacheLookup
    @FindBy(css = "[class='button btn btn-default button-medium']")
    private WebElement confirmOrder;

    public CheckoutImpl() {
        PageFactory.initElements(driver, this);
    }

    /**
     * This method is used to proceed to the Address
     * page during the checkout process
     */
    public void proceedToSecondCheckout() {
        try {
            clickOn(secondProceedCheckout, false);
            logInfo("Proceed to the Address page");
        } catch (Exception e) {
            logError("Exception while trying to proceed to the Address page during the checkout process");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to proceed to the Shipping
     * page during the checkout process
     */
    public void proceedToThirdCheckout() {
        try {
            clickOn(thirdProceedCheckout, false);
            logInfo("Proceed to the Shipping page");
        } catch (Exception e) {
            logError("Exception while trying to proceed to the Shipping page during the checkout process");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to proceed to the Payment
     * page during the checkout process
     */
    public void proceedToFourthCheckout() {
        try {
            clickOn(fourthProceedCheckout, false);
            logInfo("Proceed to the Payment page");
        } catch (Exception e) {
            logError("Exception while trying to proceed to the Payment page during the checkout process");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to proceed to accept the terms
     * and conditions during the checkout process
     */
    public void agreeToTermAndConditions() {
        try {
            clickOn(termsAndConditions, true);
            logInfo("Accept the terms and conditions");
        } catch (Exception e) {
            logError("Exception while trying to accept the terms and conditions during the checkout process");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to choose the payment
     * method during the checkout process
     */
    public void payByBankWire() {
        try {
            clickOn(bankWire, false);
            logInfo("Choose to pay by bank wire");
        } catch (Exception e) {
            logError("Exception while trying to choose the payment method during the checkout process");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to confirm the order
     * as the lat checkout step
     */
    public void confirmOrder() {
        try {
            clickOn(confirmOrder, false);
            logInfo("Confirm the order");
        } catch (Exception e) {
            logError("Exception while trying to confirm the order during the checkout process");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to assert that the checkout
     * process is completed by waiting for the order
     * completion confirmation message
     */
    public void confirmOrderCompletion(String confirmationMessage) {
        try {
            logInfo("Waiting for the order completion confirmation message to be visible");
            waitForTextToBeVisible(confirmationMessage);
            logInfo("The order completion confirmation message is now visible");
        } catch (Exception e) {
            logError("Exception while waiting for the order completion confirmation message to be visible");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }
}
