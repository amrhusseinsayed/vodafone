package stepDefinitionImplementation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionsUtil;

import java.util.Arrays;

public class ItemsImpl extends ActionsUtil {
    @CacheLookup
    @FindBy(xpath = "//iframe[contains(@name,'fancybox-frame')]")
    private WebElement fancyBox;

    @CacheLookup
    @FindBy(xpath = "//p[@id='add_to_cart']/button")
    private WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Proceed to checkout']/span")
    private WebElement proceedToCheckout;

    public ItemsImpl() {
        PageFactory.initElements(driver, this);
    }

    /**
     * This method is used to select an item that matches
     * the given name
     *
     * @param itemName item name
     */
    public void selectItem(String itemName) {
        try {
            By itemLocator = By.cssSelector(String.format("[alt='%s']"
                    , itemName));

            clickOn(itemLocator, false);

            logInfo(String.format("Select the item named '%s'"
                    , itemName));
        } catch (Exception e) {
            logError(String.format("Exception while trying to select the item named '%s'", itemName));
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to add the selected item
     * to the cart
     */
    public void addItemToCart() {
        try {
            switchToFrame(fancyBox);
            clickOn(addToCart, false);
            switchToDefaultContent();

            logInfo("Add the selected item to the cart");
        } catch (Exception e) {
            logError("Exception while trying to add the selected item to the cart");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to proceed to the
     * checkout page
     */
    public void proceedToCheckout() {
        try {
            clickOn(proceedToCheckout, true);

            logInfo("Proceed to checkout page");
        } catch (Exception e) {
            logError("Exception while proceeding to add the checkout page");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }
}
