package stepDefinition.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitionImplementation.ui.MyAccountImpl;

public class MyAccountDef {
    private MyAccountImpl account = new MyAccountImpl();

    /**
     * This method is used to add the registration email of the
     * given user by it key
     *
     * @param user the key of the user inside the test data
     *             json file
     */
    @When("user adds {string} email to create a new account")
    public void user_adds_email_to_create_a_new_account(String user) {
        account.addRegistrationEmail(user);
    }

    /**
     * This method is used to click on the create account
     * button to complete the next registration phase
     */
    @Then("user can click on the create account button")
    public void user_can_click_on_the_create_account_button() {
        account.clickOnCreateAccountBtn();
    }

    /**
     * This method is used to fill the login form with the data
     * of the given user key that exists inside the test data
     * json file
     *
     * @param user the user key inside the test data json file
     */
    @When("user fills the login form with the data of {string}")
    public void user_fills_the_login_form_with_the_data(String user) {
        account.login(user);
    }
}
