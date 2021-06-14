package stepDefinitionImplementation.ui;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionsUtil;
import utils.JsonFileUtil;

import java.util.Arrays;

public class CreateAccountImpl extends ActionsUtil {
    @CacheLookup
    @FindBy(id = "id_gender1")
    WebElement male;

    @CacheLookup
    @FindBy(id = "id_gender2")
    WebElement female;

    @CacheLookup
    @FindBy(name = "customer_firstname")
    private WebElement customerFirstName;

    @CacheLookup
    @FindBy(name = "customer_lastname")
    private WebElement customerLastName;

    @CacheLookup
    @FindBy(name = "passwd")
    private WebElement password;

    @CacheLookup
    @FindBy(name = "days")
    private WebElement days;

    @CacheLookup
    @FindBy(name = "months")
    private WebElement months;

    @CacheLookup
    @FindBy(name = "years")
    private WebElement years;

    @CacheLookup
    @FindBy(name = "newsletter")
    private WebElement newsletter;

    @CacheLookup
    @FindBy(name = "optin")
    private WebElement specialOffers;

    @CacheLookup
    @FindBy(name = "firstname")
    private WebElement firstname;

    @CacheLookup
    @FindBy(name = "lastname")
    private WebElement lastname;

    @CacheLookup
    @FindBy(name = "company")
    private WebElement company;

    @CacheLookup
    @FindBy(name = "address1")
    private WebElement address1;

    @CacheLookup
    @FindBy(name = "address2")
    private WebElement address2;

    @CacheLookup
    @FindBy(name = "city")
    private WebElement city;

    @CacheLookup
    @FindBy(name = "id_state")
    private WebElement state;

    @CacheLookup
    @FindBy(name = "postcode")
    private WebElement postcode;

    @CacheLookup
    @FindBy(name = "other")
    private WebElement additionalInformation;

    @CacheLookup
    @FindBy(name = "phone")
    private WebElement homePhone;

    @CacheLookup
    @FindBy(name = "phone_mobile")
    private WebElement mobilePhone;

    @CacheLookup
    @FindBy(name = "alias")
    private WebElement referenceAddress;

    @CacheLookup
    @FindBy(name = "submitAccount")
    private WebElement submitAccount;

    private JSONObject usersData;

    public CreateAccountImpl() {
        PageFactory.initElements(driver, this);
        usersData = usersData == null ? (JSONObject) JsonFileUtil
                .getJsonObject().get("users") : usersData;
    }

    /**
     * This method is used to fill the registration for with the data
     * of the user that matches the given key
     *
     * @param user the key of the user inside the test data json
     * @throws Exception in case of not being able to fill the fields
     *                   of the registration form
     */
    public void register(String user) throws Exception {
        JSONObject userData = (JSONObject) usersData.get(user);

        logInfo("Waiting for the registration from to be visible");
        chooseGender(userData.get("gender").toString());
        addCustomerFirstName(userData.get("customerFirstName").toString());
        addCustomerLastName(userData.get("customerLastName").toString());
        addPassword(userData.get("password").toString());
        chooseBirthDay(userData.get("birthDay").toString());
        chooseBirthMonth(userData.get("birthMonth").toString());
        chooseBirthYear(userData.get("birthYear").toString());
        setNewsletter(Boolean.parseBoolean(userData.get("newsletter")
                .toString()));
        setSpecialOffers(Boolean.parseBoolean(userData.get("specialOffers")
                .toString()));
        addFirstName(userData.get("firstName").toString());
        addLastName(userData.get("lastName").toString());
        addCompany(userData.get("company").toString());
        addAddress1(userData.get("address1").toString());
        addAddress2(userData.get("address2").toString());
        addCity(userData.get("city").toString());
        chooseState(userData.get("state").toString());
        addPostcode(userData.get("postcode").toString());
        addAdditionalInformation(userData.get("additionalInformation")
                .toString());
        addHomePhone(userData.get("homePhone").toString());
        addMobilePhone(userData.get("mobilePhone").toString());
        addReferenceAddress(userData.get("referenceAddress").toString());
        clickOnRegistrationButton();
    }

    /**
     * This method is used to select the given gender from the
     * registration form
     *
     * @param gender the gender to be selected from the form
     * @throws Exception in case of not being able to select the given
     *                   gender from the form or at trying to select
     *                   a gender that does not exist in the form
     */
    public void chooseGender(String gender) throws Exception {
        try {
            WebElement element;

            if (gender.equals("Mr.")) {
                element = male;
            } else if (gender.equals("Mrs.")) {
                element = female;
            } else {
                throw new Exception(String.format("Invalid gender: '%s'"
                        , gender));
            }

            clickOn(element, false);
            logInfo(String.format("Choosing gender as '%s'", gender));
        } catch (Exception e) {
            logError("Exception while trying to select the gender from the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the customer first name field
     * with the given data
     *
     * @param customerFirstName the data to be added
     */
    public void addCustomerFirstName(String customerFirstName) {
        try {
            addText(this.customerFirstName, customerFirstName);
            logInfo(String.format("Entering customer first name as '%s'"
                    , customerFirstName));
        } catch (Exception e) {
            logError("Exception while trying to add the customer first name of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the customer last name field
     * with the given data
     *
     * @param customerLastName the data to be added
     */
    public void addCustomerLastName(String customerLastName) {
        try {
            addText(this.customerLastName, customerLastName);
            logInfo(String.format("Entering customer last name as '%s'"
                    , customerLastName));
        } catch (Exception e) {
            logError("Exception while trying to add the customer last name of the registration form");
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
            logInfo(String.format("Entering password as '%s'"
                    , password));
        } catch (Exception e) {
            logError("Exception while trying to add the password of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to choose the given day from the
     * birth day list
     *
     * @param day the data to be selected
     */
    public void chooseBirthDay(String day) {
        try {
            selectByValue(days, day);
            logInfo(String.format("Choosing birth day as '%s'"
                    , day));
        } catch (Exception e) {
            logError("Exception while trying to choose the birth day of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to choose the given month from the
     * birth month list
     *
     * @param month the data to be selected
     */
    public void chooseBirthMonth(String month) {
        try {
            selectByValue(months, month);
            logInfo(String.format("Choosing birth month as '%s'"
                    , month));
        } catch (Exception e) {
            logError("Exception while trying to choose the birth month of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to choose the given year from the
     * birth year list
     *
     * @param year the data to be selected
     */
    public void chooseBirthYear(String year) {
        try {
            selectByValue(years, year);
            logInfo(String.format("Choosing birth year as '%s'"
                    , year));
        } catch (Exception e) {
            logError("Exception while trying to choose the birth year of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to select the newsletter option
     * in case the given parameter is true
     *
     * @param newsletter the newsletter value
     */
    public void setNewsletter(boolean newsletter) {
        try {
            if (newsletter) {
                clickOn(this.newsletter, true);
                logInfo("Selecting the newsletter option");
            }
        } catch (Exception e) {
            logError("Exception while trying to accept the newsletter option of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to select the special offers option
     * in case the given parameter is true
     *
     * @param specialOffers the special offers value
     */
    public void setSpecialOffers(boolean specialOffers) {
        try {
            if (specialOffers) {
                clickOn(this.specialOffers, true);
                logInfo("Selecting the special offers option");
            }
        } catch (Exception e) {
            logError("Exception while trying to accept the special offer option of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the first name field
     * with the given data
     *
     * @param firstName the data to be added
     */
    public void addFirstName(String firstName) {
        try {
            addText(this.firstname, firstName);
            logInfo(String.format("Entering first name as '%s'"
                    , firstName));
        } catch (Exception e) {
            logError("Exception while trying to add the first name of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the last name field
     * with the given data
     *
     * @param lastName the data to be added
     */
    public void addLastName(String lastName) {
        try {
            addText(this.lastname, lastName);
            logInfo(String.format("Entering last name as '%s'"
                    , lastName));
        } catch (Exception e) {
            logError("Exception while trying to add the last name of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the company field
     * with the given data
     *
     * @param company the data to be added
     */
    public void addCompany(String company) {
        try {
            addText(this.company, company);
            logInfo(String.format("Entering company as '%s'"
                    , company));
        } catch (Exception e) {
            logError("Exception while trying to add the company of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the address1 field
     * with the given data
     *
     * @param address1 the data to be added
     */
    public void addAddress1(String address1) {
        try {
            addText(this.address1, address1);
            logInfo(String.format("Entering address1 as '%s'"
                    , address1));
        } catch (Exception e) {
            logError("Exception while trying to add the address1 of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the address2 field
     * with the given data
     *
     * @param address2 the data to be added
     */
    public void addAddress2(String address2) {
        try {
            addText(this.address2, address2);
            logInfo(String.format("Entering address2 as '%s'"
                    , address2));
        } catch (Exception e) {
            logError("Exception while trying to add the address2 of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the city field
     * with the given data
     *
     * @param city the data to be added
     */
    public void addCity(String city) {
        try {
            addText(this.city, city);
            logInfo(String.format("Entering city as '%s'"
                    , city));
        } catch (Exception e) {
            logError("Exception while trying to add the city of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to choose the given state from the
     * states list
     *
     * @param state the data to be selected
     */
    public void chooseState(String state) {
        try {
            selectByText(this.state, state);
            logInfo(String.format("Choosing state as '%s'"
                    , state));
        } catch (Exception e) {
            logError("Exception while trying to choose the state of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the postcode field
     * with the given data
     *
     * @param postcode the data to be added
     */
    public void addPostcode(String postcode) {
        try {
            addText(this.postcode, postcode);
            logInfo(String.format("Entering postcode as '%s'"
                    , postcode));
        } catch (Exception e) {
            logError("Exception while trying to add the postcode of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the additional information
     * field with the given data
     *
     * @param additionalInformation the data to be added
     */
    public void addAdditionalInformation(String additionalInformation) {
        try {
            addText(this.additionalInformation, additionalInformation);
            logInfo(String.format("Entering additional information as '%s'"
                    , additionalInformation));
        } catch (Exception e) {
            logError("Exception while trying to add the additional information of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the home phone field
     * with the given data
     *
     * @param homePhone the data to be added
     */
    public void addHomePhone(String homePhone) {
        try {
            addText(this.homePhone, homePhone);
            logInfo(String.format("Entering home phone as '%s'"
                    , homePhone));
        } catch (Exception e) {
            logError("Exception while trying to add the home phone of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the mobile phone field
     * with the given data
     *
     * @param mobilePhone the data to be added
     */
    public void addMobilePhone(String mobilePhone) {
        try {
            addText(this.mobilePhone, mobilePhone);
            logInfo(String.format("Entering mobile phone as '%s'"
                    , mobilePhone));
        } catch (Exception e) {
            logError("Exception while trying to add the mobile phone of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to fill the reference address field
     * with the given data
     *
     * @param referenceAddress the data to be added
     */
    public void addReferenceAddress(String referenceAddress) {
        try {
            addText(this.referenceAddress, referenceAddress);
            logInfo(String.format("Entering reference address as '%s'"
                    , referenceAddress));
        } catch (Exception e) {
            logError("Exception while trying to add the reference address of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to click on the submit button
     * of the registration for
     */
    public void clickOnRegistrationButton() {
        try {
            clickOn(submitAccount, false);
            logInfo("Click on the registration submit button");
        } catch (Exception e) {
            logError("Exception while trying to click on the submit button of the registration form");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }
}
