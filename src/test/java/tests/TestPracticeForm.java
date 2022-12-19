package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1460x800";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void testPracticeForm() {

        open("/automation-practice-form");

        $("#firstName").setValue("Denis");
        $("#lastName").setValue("Antonov");
        $("#userEmail").setValue("denis@gmail.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("9505555555");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--021").click();
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Computer Science");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat_pic2.webp"));
        $("#currentAddress").setValue("My adress");
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Denis Antonov"), text("denis@gmail.com"), text("21 January,1989"), text("Male"), text("Computer Science"), text("My adress"), text("9505555555"), text("Reading"), text("cat_pic2.webp"));
    }
}

