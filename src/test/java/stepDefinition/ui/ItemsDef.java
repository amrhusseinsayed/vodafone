package stepDefinition.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitionImplementation.ui.ItemsImpl;

public class ItemsDef {
    private ItemsImpl item = new ItemsImpl();

    /**
     * This method is used to select an item that matches
     * the given name
     *
     * @param itemName item name
     */
    @When("selects the item named {string}")
    public void selects_the_item_named(String itemName) {
        item.selectItem(itemName);
    }

    /**
     * This method is used to add the selected item
     * to the cart
     */
    @Then("user can add the selected item to his cart")
    public void user_can_add_the_selected_item_to_his_cart() {
        item.addItemToCart();
    }

    /**
     * This method is used to proceed to the
     * checkout page
     */
    @Then("proceed to the checkout page")
    public void proceed_to_the_checkout_page() {
        item.proceedToCheckout();
    }
}
