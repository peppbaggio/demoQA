package practiceform.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import practiceform.TestBase;
import practiceform.page.Steps;

import static practiceform.data.TestData.*;

public class PracticeFormWithFakerTests extends TestBase {

    @Test
    @Tag("full")
    @Tag("test")
    @DisplayName("Это полный позитивный тест")
    void practiceFormCompleteTests() {

        practiceform.page.Steps steps = new Steps();

        steps.openPage();
        steps.getFirstName();
        steps.getSurname();
        steps.getUserEmail();
        steps.getUserPhone();
        steps.getUserGender();
        steps.getCalendarDate();
        steps.getSubjects();
        steps.getHobbies();
        steps.uploadPicture();
        steps .getAddress();
        steps.selectStateAndCity();

        steps.submitClick();

        steps.checkPageOpen("Thanks for submitting the form");
        steps.checkResults("Student Name", fakerFirstName + " " + fakerSurname);
        steps.checkResults("Student Email", fakerEmail);
        steps.checkResults("Mobile", fakerPhone);
        steps.checkResults("Gender", fakerGender);
        steps.checkResults("Date of Birth", fakerCalendarDate[0] + " " + fakerCalendarDate[1] + "," + fakerCalendarDate[2]);
        steps .checkResults("Subjects", fakerSubjects);
        steps.checkResults("Hobbies", fakerHobbies);
        steps.checkResults("Picture", fakerPicture);
        steps.checkResults("Address", fakerAddress);
        steps .checkResults("State and City", fakerStateAndCity[0] + " " + fakerStateAndCity[1]);

    }

    @Test
    @Tag("required")
    @Tag("test")
    @DisplayName("Это позитивный тест на обязательные поля")
    void practiceFormRequiredTests() {

        practiceform.page.Steps steps = new Steps();

        steps.openPage();
        steps.getFirstName();
        steps.getSurname();
        steps.getUserPhone();
        steps.getUserGender();
        steps.submitClick();

        steps.checkPageOpen("Thanks for submitting the form");
        steps.checkResults("Student Name", fakerFirstName + " " + fakerSurname);
        steps.checkResults("Mobile", fakerPhone);
        steps.checkResults("Gender", fakerGender);
        steps.checkNegativeResults("Student Email");
        steps.checkNegativeResults("Subjects");
        steps.checkNegativeResults("Hobbies");
        steps.checkNegativeResults("Picture");
        steps.checkNegativeResults("Address");
        steps.checkNegativeResults("State and City");

    }

    @Test
    @Tag("negative")
    @Tag("test")
    @DisplayName("Это негативный тест на обязательные поля с пустым именем")
    void negativeFirstNamePracticeFormRequiredTests() {

        practiceform.page.Steps steps = new Steps();

        steps.openPage();
        steps.getSurname();
        steps.getUserPhone();
        steps.getUserGender();
        steps.submitClick();

        steps.checkPageNotOpen();

    }

    @Test
    @Tag("negative")
    @Tag("test")
    @DisplayName("Это негативный тест на обязательные поля с пустым гендером")
    void negativeNoGenderPracticeFormRequiredTests() {

        practiceform.page.Steps steps = new Steps();

        steps.openPage();
        steps .getFirstName();
        steps.getSurname();
        steps.getUserPhone();
        steps.submitClick();

        steps.checkPageNotOpen();

    }
}
