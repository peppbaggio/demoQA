package guru.qa.data;

import com.github.javafaker.Faker;

public class FakerData {

Faker faker = new Faker();

public String setNumber() {
    String number = faker.number().digits(10);
    return number;
}
}
