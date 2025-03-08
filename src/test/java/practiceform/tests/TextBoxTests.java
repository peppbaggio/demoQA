package practiceform.tests;

import org.junit.jupiter.api.Test;
import practiceform.TestBase;
import practiceform.page.TextBoxPageObject;

public class TextBoxTests extends TestBase {

    TextBoxPageObject textBoxPageObject = new TextBoxPageObject();

    @Test
    void textBoxPositiveTests() {

        textBoxPageObject.openTextBoxPage("Text Box")
                .setUserName("Montgomery Swartz")
                .setUserEmail("swartz@gmail.com")
                .setCurrentAddress("Town Street House")
                .setPermanentAddress("Another Town, Another Street House No. 5")
                .submitButton()

                .checkOutputUserName("Montgomery Swartz")
                .checkOutputUserEmail("swartz@gmail.com")
                .checkOutputUserCurrentAddress("Town Street House")
                .checkOutputUserPermanentAddress("Another Town, Another Street House No. 5");

    }

}
