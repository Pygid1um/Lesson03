package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    CalendarComponent calendar = new CalendarComponent();

    //locators
    SelenideElement firstNameInput      = $("#firstName");
    SelenideElement lastNameInput       = $("#lastName");
    SelenideElement userEmailInput      = $("#userEmail");
    SelenideElement genderInput         = $("#genterWrapper");
    SelenideElement phoneNumberInput    = $("#userNumber");
    SelenideElement dateOfBirthInput     = $("#dateOfBirthInput");
    SelenideElement firstSubjectInput   = $("#subjectsInput");
    SelenideElement secondSubjectInput  = $("#subjectsInput");
    SelenideElement firstHobbyInput     = $("#hobbiesWrapper");
    SelenideElement secondHobbyInput    = $("#hobbiesWrapper");
    SelenideElement fileInput           = $("#uploadPicture");
    SelenideElement adressInput         = $("#currentAddress");
    SelenideElement stateInput          = $(byText("Select State"));
    SelenideElement cityInput           = $(byText("Select City"));
    SelenideElement checkResulsInput    = $(".modal-body");

    //actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public RegistrationFormPage clickGender(String gender) {
        genderInput.$(byText(gender)).click();

        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    public RegistrationFormPage setOfBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(year,month,day);

        return this;
    }

    public RegistrationFormPage setSubjects(String firstSubject, String secondSubject) {
        firstSubjectInput.setValue(firstSubject).pressEnter();
        secondSubjectInput.setValue(secondSubject).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String firstHobby, String secondHobby) {
        firstHobbyInput.$(byText(firstHobby)).click();
        secondHobbyInput.$(byText(secondHobby)).click();

        return this;
    }

    public RegistrationFormPage uploadPictures(String file) {
        fileInput.uploadFromClasspath(file);

        return this;
    }

    public RegistrationFormPage setAdress(String adress) {
        adressInput.setValue(adress);

        return this;
    }

    public RegistrationFormPage setStateAndCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();

        return this;
    }


    public RegistrationFormPage clickSubmit() {
        $("#submit").click();

        return this;
    }

    //проверки
    public RegistrationFormPage checkResulsTests(
            String expectedFullName,
            String email,
            String gender,
            String phoneNumber,
            String expectedFullDate,
            String expectedFullSubjects,
            String expectedFullHibbys,
            String file,
            String adress,
            String expectedFullStaseAndCity
    ){
        checkResulsInput.shouldHave(
                text(expectedFullName),
                text(email),
                text(gender),
                text(phoneNumber),
                text(expectedFullDate),
                text(expectedFullSubjects),
                text(expectedFullHibbys),
                text(file),
                text(adress),
                text(expectedFullStaseAndCity)
        );
        return this;
    }
}
