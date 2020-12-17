package utils;

import com.github.javafaker.Faker;

public class RandomUser {

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String address1;
    public int zipCode;
    public int dayOfBirth;
    public int monthOfBirth;
    public int yearOfBirth;
    public String city;
    public int mobile;

    @Override
    public String toString() {
        return "RandomUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address1='" + address1 + '\'' +
                ", zipCode=" + zipCode +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                ", city='" + city + '\'' +
                ", mobile=" + mobile +
                '}';
    }

    public RandomUser() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        dayOfBirth = (faker.random().nextInt(1, 31));
        monthOfBirth = faker.random().nextInt(1, 12);
        yearOfBirth = faker.random().nextInt(1910, 2020);
        email = firstName + lastName + yearOfBirth + "@gmail.com";
        zipCode = faker.random().nextInt(10000, 99999);
        address1 = faker.address().streetAddress();
        city = faker.address().city();
        mobile = faker.random().nextInt(100000000, 999999999);
        password = "haslo123";


    }

}
