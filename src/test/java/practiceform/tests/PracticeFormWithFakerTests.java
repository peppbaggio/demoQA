package practiceform.tests;

import org.junit.jupiter.api.Test;
import practiceform.TestBase;
import practiceform.page.RegistrationPage;

import static practiceform.data.TestData.*;

public class PracticeFormWithFakerTests extends TestBase {

    practiceform.page.RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void practiceFormCompleteTests() {

        System.out.println("Это полный позитивный тест");
        registrationPage.openPage()
                .getFirstName()
                .getSurname()
                .getUserEmail()
                .getUserPhone()
                .getUserGender()
                .getCalendarDate()
                .getSubjects()
                .getHobbies()
                .uploadPicture()
                .getAddress()
                .selectStateAndCity()

                .submitClick()

                .checkPageOpen("Thanks for submitting the form")
                .checkResults("Student Name", fakerFirstName + " " + fakerSurname)
                .checkResults("Student Email", fakerEmail)
                .checkResults("Mobile", fakerPhone)
                .checkResults("Gender", fakerGender)
                .checkResults("Date of Birth", fakerCalendarDate[0] + " " + fakerCalendarDate[1] + "," + fakerCalendarDate[2])
                .checkResults("Subjects", fakerSubjects)
                .checkResults("Hobbies", fakerHobbies)
                .checkResults("Picture", fakerPicture)
                .checkResults("Address", fakerAddress)
                .checkResults("State and City", fakerStateAndCity[0] + " " + fakerStateAndCity[1]);

    }

    @Test
    void practiceFormRequiredTests() {

        System.out.println("Это позитивный тест на обязательные поля");
        registrationPage.openPage()
                .getFirstName()
                .getSurname()
                .getUserPhone()
                .getUserGender()
                .submitClick()

                .checkPageOpen("Thanks for submitting the form")
                .checkResults("Student Name", fakerFirstName + " " + fakerSurname)
                .checkResults("Mobile", fakerPhone)
                .checkResults("Gender", fakerGender)
                .checkNegativeResults("Student Email")
                .checkNegativeResults("Subjects")
                .checkNegativeResults("Hobbies")
                .checkNegativeResults("Picture")
                .checkNegativeResults("Address")
                .checkNegativeResults("State and City");

    }

    @Test
    void negativeFirstNamePracticeFormRequiredTests() {

        System.out.println("Это негативный тест на обязательные поля с пустым именем");

        registrationPage.openPage()
                .getSurname()
                .getUserPhone()
                .getUserGender()
                .submitClick()

                .checkPageNotOpen();

    }

    @Test
    void negativeNoGenderPracticeFormRequiredTests() {

        System.out.println("Это негативный тест на обязательные поля с пустым гендером");

        registrationPage.openPage()
                .getFirstName()
                .getSurname()
                .getUserPhone()
                .submitClick()

                .checkPageNotOpen();

    }
}
