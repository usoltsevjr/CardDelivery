package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryListTest {

    @Test
    void shouldShowListOfCities() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Са");
        $$(".menu-item .menu-item__control").find(exactText("Астрахань")).click();

        $("[data-test-id='city'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='city'] input").setValue("Са");
        $$(".menu-item .menu-item__control").find(exactText("Кострома")).click();

        $("[data-test-id='city'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='city'] input").setValue("Са");
        $$(".menu-item .menu-item__control").find(exactText("Москва")).click();

        $("[data-test-id='city'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='city'] input").setValue("Са");
        $$(".menu-item .menu-item__control").find(exactText("Самара")).click();

        $("[data-test-id='city'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='city'] input").setValue("Са");
        $$(".menu-item .menu-item__control").find(exactText("Сыктывкар")).click();

        $("[data-test-id='city'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='city'] input").setValue("Са");
        $$(".menu-item .menu-item__control").find(exactText("Санкт-Петербург")).click();
    }

    @Test
    void shouldSelectDateOnNextWeek() {
        open("http://localhost:9999");

        LocalDate currentDate = LocalDate.now();
        LocalDate dateOfDelivery = LocalDate.now().plusDays(7);
        String day = dateOfDelivery.format(DateTimeFormatter.ofPattern("d"));
        $(".input__icon").click();
        if (dateOfDelivery.getMonthValue() - currentDate.getMonthValue() == 1) {
            $("[data-step='1']").click();
        }
        $$("td.calendar__day").find(exactText(day)).click();
    }

    @Test
    void shouldTestCorrectForm() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Са");
        $$(".menu-item .menu-item__control").find(exactText("Ярославль")).click();

        LocalDate currentDate = LocalDate.now();
        LocalDate dateOfDelivery = LocalDate.now().plusDays(7);
        String date = dateOfDelivery.format(DateTimeFormatter.ofPattern("d"));
        $(".input__icon").click();
        if (dateOfDelivery.getMonthValue() - currentDate.getMonthValue() == 1) {
            $("[data-step='1']").click();
        }
        $$("td.calendar__day").find(exactText(date)).click();

        $("[data-test-id='name'] input").setValue("Антонов Антон");
        $("[data-test-id='phone'] input").setValue("+79217895546");
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).waitUntil(visible, 11000);
        $(byText("Встреча успешно забронирована на"));

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateDelivery = formatter1.format(dateOfDelivery);
        $(byText(dateDelivery));
    }
}
