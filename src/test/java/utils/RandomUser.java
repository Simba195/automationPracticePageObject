package utils;

import com.github.javafaker.Faker;

public class RandomUser {

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String address1;
    int zipCode;
    int dayOfBirth;
    int monthOfBirth;
    int yearOfBirth;

    public RandomUser(){
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        yearOfBirth = faker.random().nextInt(1910, 2020);
        email = firstName + lastName + yearOfBirth + "@gmail.com";
        zipCode = faker.random().nextInt(10000, 99999);

    }
}
