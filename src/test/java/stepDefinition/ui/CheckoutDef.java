package stepDefinition.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitionImplementation.ui.CheckoutImpl;

public class CheckoutDef {
    private CheckoutImpl checkout = new CheckoutImpl();

    /**
     * This method is used to proceed to the Address
     * page during the checkout process
     */
    @When("user proceeds to the Address page")
    public void user_proceeds_to_the_address_page() {
        checkout.proceedToSecondCheckout();
    }

    /**
     * This method is used to proceed to the Shipping
     * page during the checkout process
     */
    @When("proceeds to the Shipping page")
    public void proceeds_to_the_shipping_page() {
        checkout.proceedToThirdCheckout();
    }

    /**
     * This method is used to proceed to accept the terms
     * and conditions during the checkout process
     */
    @When("accepts the terms and conditions")
    public void accepts_the_terms_and_conditions() {
        checkout.agreeToTermAndConditions();
    }

    /**
     * This method is used to proceed to the Payment
     * page during the checkout process
     */
    @Then("user can proceed to the Payment page")
    public void user_can_proceed_to_the_payment_page() {
        checkout.proceedToFourthCheckout();
    }

    /**
     * This method is used to choose the payment
     * method during the checkout process
     */
    @When("user chooses to pay by bank wire")
    public void user_chooses_to_pay_by_bank_wire() {
        checkout.payByBankWire();
    }

    /**
     * This method is used to confirm the order
     * as the lat checkout step
     */
    @When("confirms the order")
    public void confirms_the_order() {
        checkout.confirmOrder();
    }

    /**
     * This method is used to assert that the checkout
     * process is completed by waiting for the order
     * confirmation message
     */
    @Then("the order confirmation message {string} should be visible")
    public void the_order_confirmation_message_should_be_visible(String confirmationMessage) {
        checkout.confirmOrderCompletion(confirmationMessage);
    }
}
