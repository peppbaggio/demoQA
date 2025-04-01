package practiceform.data;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {

    static Faker faker = new Faker();


    public static String setFirstName() {
        String name = faker.name().firstName();
        return name;
    }

    public static String setSurname() {
        String name = faker.name().lastName();
        return name;
    }

    public static String setEmail() {
        String email = faker.internet().emailAddress();
        return email;
    }

    public static String setPhoneNumber() {
        String phone = faker.number().digits(10);
        return phone;
    }

    public static String setGender() {
        String gender = faker.options().option("Male", "Female", "Other");
        return gender;
    }

    public static String[] setCalendarDate() {

        Date randDate = faker.date().birthday(18, 75);
        SimpleDateFormat formattedDate = new SimpleDateFormat
                ("dd-MMMM-yyyy", Locale.ENGLISH);

        String[] date = formattedDate.format(randDate).split("-");

        return date;
    }

    public static String setSubjects() {
        String subject = faker.options().option("Maths", "Arts", "Chemistry", "Physics", "Computer Science");
        return subject;
    }

    public static String setHobbies() {
        String hobby = faker.options().option("Sports", "Reading");
        return hobby;
    }

    public static String setPicture() {
        String picture = faker.options().option("picture.jpeg", "weather.jpg");
        return picture;
    }

    public static String setAddress() {
        String address = faker.address().fullAddress();
        return address;
    }

    public static String[] setStateAndCity() {
        StateAndCity stateAndCity = new StateAndCity();
        String[] cityInState = stateAndCity.getStateAndCity();

        return cityInState;
    }

    public static String fakerFirstName = setFirstName();
    public static String fakerSurname = setSurname();
    public static String fakerEmail = setEmail();
    public static String fakerPhone = setPhoneNumber();
    public static String fakerGender = setGender();
    public static String[] fakerCalendarDate = setCalendarDate();
    public static String fakerSubjects = setSubjects();
    public static String fakerHobbies = setHobbies();
    public static String fakerPicture = setPicture();
    public static String fakerAddress = setAddress();
    public static String[] fakerStateAndCity = setStateAndCity();

}
