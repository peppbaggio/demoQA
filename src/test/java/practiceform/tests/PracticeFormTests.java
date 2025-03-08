package practiceform.tests;

import org.junit.jupiter.api.Test;
import practiceform.TestBase;
import practiceform.page.RegistrationPage;

public class PracticeFormTests extends TestBase {


    practiceform.page.RegistrationPage RegistrationPage = new RegistrationPage();

    @Test
    void practiceFormCompleteTests() {

        System.out.println("Это полный позитивный тест");
        RegistrationPage.openPage()

                .setFirstName("Max")
                .setSurname("Frix")
                .setUserEmail("frix@frix.ii")
                .setUserNumber("1234567890")


                .setUserGender()
                .setCalendarDate("12", "December", "1998")
                .setSubjects("Maths")
                .setHobbies()
                .uploadPicture("img/weather.jpg")
                .setAddress("State Town Street")
                .selectStateAndCity("Haryana", "Panipat")

                .submitClick()

                .checkPageOpen("Thanks for submitting the form")
                .checkResults("Student Name", "Max Frix")
                .checkResults("Student Email", "frix@frix.ii")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "1234567890")
                .checkResults("Date of Birth", "12 December,1998")
                .checkResults("Subjects", "Maths")
                .checkResults("Hobbies", "Reading")
                .checkResults("Picture", "weather.jpg")
                .checkResults("Address", "State Town Street")
                .checkResults("State and City", "Haryana Panipat");

    }

    @Test
    void practiceFormRequiredTests() {

        System.out.println("Это позитивный тест на обязательные поля");
        RegistrationPage.openPage()

                .setFirstName("Max")
                .setSurname("Frix")
                .setUserNumber("1234567890")
                .setUserGender()
                .submitClick()

                .checkPageOpen("Thanks for submitting the form")
                .checkResults("Student Name", "Max Frix")
                .checkResults("Mobile", "1234567890")
                .checkResults("Gender", "Male")
                .checkResults("Date of Birth", " ")
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

        RegistrationPage.openPage()

                .setSurname("Frix")
                .setUserNumber("1234567890")
                .setUserGender()
                .submitClick()

                .checkPageNotOpen();

    }

    @Test
    void negativeNoGenderPracticeFormRequiredTests() {

        System.out.println("Это негативный тест на обязательные поля с пустым полом");

        RegistrationPage.openPage()

                .setFirstName("Max")
                .setSurname("Frix")
                .setUserNumber("1234567890")
                .submitClick()

                .checkPageNotOpen();

    }

}
