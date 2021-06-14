package stepDefinitionImplementation.ui;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionsUtil;
import utils.JsonFileUtil;

import java.util.Arrays;

public class MyAccountImpl extends ActionsUtil {
    @CacheLookup
    @FindBy(id = "email")
    private WebElement loginEmail;

    @CacheLookup
    @FindBy(id = "passwd")
    private WebElement password;

    @CacheLookup
    @FindBy(id = "SubmitLogin")
    private WebElement signIn;

    @CacheLookup
    @FindBy(id = "email_create")
    private WebElement registrationEmail;

    @CacheLookup
    @FindBy(id = "SubmitCreate")
    private WebElement createAccount;

    private JSONObject usersData;

    public MyAccountImpl() {
        PageFactory.initElements(driver, this);
        usersData = usersData == null ? (JSONObject) JsonFileUtil
                .getJsonObject().get("users") : usersData;
    }

    /**
     * This method is used to add the registration email of the
     * given user by it key
     *
     * @param user the key of the user inside the test data
     *             json file
     */
    public void addRegistrationEmail(String user) {
        try {
            JSONObject userData = (JSONObject) usersData.get(user);
            var email = userData.get("email").toString();

            addText(registrationEmail, email);
            logInfo(String.format("Entering the registration mail as '%s'"
                    , email));
        } catch (Exception e) {
            logError("Exception while trying to add the registration email");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to click on the create account
     * button to complete the next registration phase
     */
    public void clickOnCreateAccountBtn() {
        try {
            clickOn(createAccount, false);
            logInfo("Click on the create account button");
        } catch (Exception e) {
            logError("Exception while trying to click on the create account button");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the login form with the data
     * of the given user key that exists inside the test data
     * json file
     *
     * @param user the user key inside the test data json file
     */
    public void login(String user) {
        JSONObject userData = (JSONObject) usersData.get(user);

        logInfo("Starting to fill the login form");
        addLoginEmail(userData.get("email").toString());
        addPassword(userData.get("password").toString());
        clickOnSignInButton();
    }

    /**
     * This method is used to fill the login field
     * with the given data
     *
     * @param email the data to be added
     */
    public void addLoginEmail(String email) {
        try {
            addText(loginEmail, email);
            logInfo(String.format("Entering login email as '%s'"
                    , email));
        } catch (Exception e) {
            logError("Exception while trying to add the email of the login form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the password field
     * with the given data
     *
     * @param password the data to be added
     */
    public void addPassword(String password) {
        try {
            addText(this.password, password);
            logInfo(String.format("Entering login password as '%s'"
                    , password));
        } catch (Exception e) {
            logError("Exception while trying to add the password of the login form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to click on the sign in button
     */
    public void clickOnSignInButton() {
        try {
            clickOn(signIn, false);
            logInfo("Click on the sign in button");
        } catch (Exception e) {
            logError("Exception while trying to click on the submit button of the login form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }
}
