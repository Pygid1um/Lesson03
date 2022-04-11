package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationFormPageDemoQa {

    Faker faker = new Faker();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    //variables

    String firstName      = faker.name().firstName(),
            lastName      = faker.name().lastName(),
            email         = faker.internet().emailAddress(),
            gender        = "Male",
            phoneNumber   = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth    = "22",
            monthOfBirth  = "June",
            yearOfBirth   = "1995",
            firstSubject  = "English",
            secondSubject = "Chemistry",
            firstHobby    = "Music",
            secondHobby   = "Reading",
            file          = "123.PNG",
            adress        = faker.address().fullAddress(),
            state         = "NCR",
            city          = "Noida";


    String expectedFullName            = format("%s %s", firstName, lastName),
            expectedFullDate           = format("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth),
            expectedFullSubjects       = format("%s, %s", firstSubject, secondSubject),
            expectedFullHibbys         = format("%s, %s", firstHobby, secondHobby),
            expectedFullStaseAndCity   = format("%s %s", state, city);

    @BeforeAll
    static void settingsTest() {
        Configuration.baseUrl         = "https://demoqa.com";
        Configuration.browserSize     = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .clickGender(gender)
                .setPhoneNumber(phoneNumber)
                .setOfBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(firstSubject, secondSubject)
                .setHobbies(firstHobby, secondHobby)
                .uploadPictures(file)
                .setAdress(adress)
                .setStateAndCity(state, city)
                .clickSubmit();

        //Проверки
        registrationFormPage.checkResulsTests(
                expectedFullName,
                email,
                gender,
                phoneNumber,
                expectedFullDate,
                expectedFullSubjects,
                expectedFullHibbys,
                file,
                adress,
                expectedFullStaseAndCity
        );
    }
}
