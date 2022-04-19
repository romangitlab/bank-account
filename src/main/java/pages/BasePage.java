package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    protected ArrayList<String> getListOfErrorMessages(ElementsCollection elements){
        ArrayList<String> listErrors = new ArrayList<>();

        for (SelenideElement element : elements) {
            if (element.getText().equals("")) continue;
            listErrors.add(element.getText());
        }

        return listErrors;
    }

    public void clickAtAcceptAllPrivacySettings(){
        $(shadowCss("button[data-testid='uc-accept-all-button']", "#usercentrics-root")).click();
    }
}
