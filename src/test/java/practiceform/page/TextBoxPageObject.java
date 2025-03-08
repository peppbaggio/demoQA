package practiceform.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPageObject {

    private SelenideElement userName = $("#userName");
    private SelenideElement userEmail = $("#userEmail");
    private SelenideElement userCurrentAddress = $("#currentAddress");
    private SelenideElement userPermanentAddress = $("#permanentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputUserName = $("#output #name");
    private SelenideElement outputUserEmail = $("#output #email");
    private SelenideElement outputUserCurrentAddress = $("#output #currentAddress");
    private SelenideElement outputUserPermanentAddress = $("#output #permanentAddress");

    public TextBoxPageObject openTextBoxPage(String titleText) {
        open("/text-box");
        $("h1").shouldHave(text(titleText));
        return this;
    }

    public TextBoxPageObject setUserName(String fullName) {
        userName.scrollIntoView(true).setValue(fullName);
        return this;

    }

    public TextBoxPageObject setUserEmail(String email) {
        userEmail.scrollIntoView(true).setValue(email);
        return this;
    }

    public TextBoxPageObject setCurrentAddress(String currentAddress) {
        userCurrentAddress.scrollIntoView(true).setValue(currentAddress);
        return this;
    }

    public TextBoxPageObject setPermanentAddress(String permanentAddress) {
        userPermanentAddress.scrollIntoView(true).setValue(permanentAddress);
        return this;
    }

    public TextBoxPageObject submitButton() {
        submitButton.scrollIntoView(true).click();
        return this;
    }

    public TextBoxPageObject checkOutputUserName(String fullName) {
        outputUserName.scrollIntoView(true).shouldHave(text(fullName));
        return this;
    }

    public TextBoxPageObject checkOutputUserEmail(String email) {
        outputUserEmail .scrollIntoView(true).shouldHave(text(email));
        return this;
    }

    public TextBoxPageObject checkOutputUserCurrentAddress(String currentAddress) {
        outputUserCurrentAddress.scrollIntoView(true).shouldHave(text(currentAddress));
        return this;
    }

    public TextBoxPageObject checkOutputUserPermanentAddress(String permanentAddress) {
        outputUserPermanentAddress.scrollIntoView(true).shouldHave(text(permanentAddress));
        return this;
    }


}


