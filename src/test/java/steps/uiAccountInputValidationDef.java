package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class uiAccountInputValidationDef {

    LoginPage lp = new LoginPage();

    @Given("customer is in a login page")
    public void customerIsInALoginPage() {
        lp.clickAtAcceptAllPrivacySettings();
        assertThat(title(), containsStringIgnoringCase(lp.pageTitle));
    }

    @When("customer selects create account link")
    public void customerSelectsCreateAccountLink() {
        lp.clickAtCreateAccountLink();
        assertThat(url(), containsStringIgnoringCase(lp.urlCreateaccount));
    }

    @And("customer inserts {string} e-mail address")
    public void customerInsertsEMailAddress(String email) {
        lp.insertNewAccountEmail(email);
        lp.clickAtCreateAccountBtn();
    }

    @Then("customer is redirected to the {string} page")
    public void customerIsRedirectedToTheAuthenticationConfirmationemailsentPage(String page) {
        assertThat(url(), containsStringIgnoringCase(page));
    }

    @And("{string} message is shown")
    public void messageIsShown(String message) {
        lp.checkMessagePanelIsShownWithMessage(message);
    }

    @When("customer selects login with 'e-mail and password' option")
    public void customerSelectsLoginWithEMailAndPasswordOption() {
        lp.clickAtEmailAndPasswordTabLink();
        assertThat(url(), containsStringIgnoringCase(lp.urlEmailandpassword));
    }

    @And("customer inserts invalid {string} email address")
    public void customerInsertsInvalidEmailAddress(String email) {
        lp.insertLoginEmail(email);
        lp.insertLoginPassword("");
    }

    @Then("error validation message is shown")
    public void errorValidationMessageIsShown() {
        assertThat(lp.getListOfValidationMessageErrors(), is(not(empty())));
        assertThat(lp.getListOfValidationMessageErrors().size(), equalTo(1));
    }

    @And("customer inserts {string} email address and {string} password")
    public void customerInsertsEmailAddressAndPassword(String email, String password) {
        lp.insertLoginEmail(email);
        lp.insertLoginPassword(password);
        lp.clickAtEmailAndPasswordBtn();
    }

    @And("error notification summary message is shown")
    public void errorNotificationSummeryMessageIsShown() {
        assertThat(lp.getListOfNotificationSummaryErrors(), is(not(empty())));
        assertThat(lp.getListOfNotificationSummaryErrors().size(), equalTo(1));
    }
}
