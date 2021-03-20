import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTests {

    String siteUrl = "https://demoqa.com/automation-practice-form";
    String name = "John";
    String surname = "Smith";
    String email = "jsmith@yahoo.com";
    String gender = "Male";
    String phone = "9229289289";
    String birthYear = "1987";
    String birthMonth = "June";
    String birthDay = "25";
    String hobby1 = "Sports";
    String hobby2 = "Reading";
    String fileName = "picture.jpg";
    String address = "347922, Russia, Taganrog";
    String shortSubject1 = "Hi";
    String shortSubject2 = "Co";
    String subject1 = "History";
    String subject2 = "Computer Science";
    String state = "NCR";
    String city = "Delhi";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillRegistrationForm() {
        open(siteUrl);

        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(birthYear);
        $(".react-datepicker__month-select").selectOptionContainingText(birthMonth);
        $(byText(birthDay)).click();
        $("#subjectsInput").setValue(shortSubject1);
        $(byText(subject1)).click();
        $("#subjectsInput").setValue(shortSubject2);
        $(byText(subject2)).click();
        $(byText(hobby1)).click();
        $(byText(hobby2)).click();
        $("#uploadPicture").uploadFromClasspath(fileName);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        //Assertions
        $(".table-responsive").shouldHave(text(name), text(surname), text(email), text(gender), text(phone), text(subject1),
                text(subject2), text(hobby1), text(hobby2), text(fileName), text(address), text(state), text(city),
                text(birthDay + " " + birthMonth + "," + birthYear));
        $("#closeLargeModal").click();
    }
}

