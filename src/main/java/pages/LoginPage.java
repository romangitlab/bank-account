package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginPage extends BasePage {

    public String pageTitle = "Login - Welcome to MyAfterPay!";
    public String urlCreateaccount = "?type=createaccount";
    public String urlEmailandpassword = "?type=emailandpassword";

    public void clickAtCreateAccountLink(){
        $("#login-create-account a").click();
    }

    public void clickAtEmailAndPasswordTabLink(){
        $("div#welcome button#emailandpasswordTabLink").click();
    }

    public void checkMessagePanelIsShownWithMessage(String message){
        $("div.login-panel__confirmation").shouldBe(visible);
        $("div.login-panel__confirmation").shouldHave(text(message));
    }

    public void insertNewAccountEmail(String email){
        $("#NewAccountEmail").sendKeys(email);
    }

    public void insertLoginEmail(String email){
        $("#EmailAndPasswordModel_Email").sendKeys(email);
    }

    public void insertLoginPassword(String email){
        $("#EmailAndPasswordModel_Password").sendKeys(email);
    }

    public void clickAtCreateAccountBtn(){
        $("button#SubmitCreateAccount").submit();
    }

    public void clickAtEmailAndPasswordBtn(){
        $("button#EmailAndPasswordBtn").submit();
    }

    public ArrayList<String> getListOfValidationMessageErrors(){
        return getListOfErrorMessages($$("span.error-message"));
    }

    public ArrayList<String> getListOfNotificationSummaryErrors(){
        return getListOfErrorMessages($$("div.notification-summary-error"));
    }
}


