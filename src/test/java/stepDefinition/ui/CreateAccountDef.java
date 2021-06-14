package stepDefinition.ui;

import io.cucumber.java.en.When;
import stepDefinitionImplementation.ui.CreateAccountImpl;

public class CreateAccountDef {
    CreateAccountImpl account = new CreateAccountImpl();

    /**
     * This method is used to fill the registration form with the
     * user data based on the given user key inside the test
     * data json file
     *
     * @param user the key of the user inside the test data json
     * @throws Exception in case of not being able to fill the
     *                   desired fields inside the registration form
     */
    @When("user fills the registration form with the data of {string}")
    public void user_fills_the_registration_form_with_the_data_of(
            String user) throws Exception {
        account.register(user);
    }
}
