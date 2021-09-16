package tests.web;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("UI")
@Owner("Paleev O.")
@Feature("Main Page")
@JiraIssues({@JiraIssue("HOM-234")})
public class MainPageTests extends WebTestBase {

    static final String MAINPAGE = "https://www.tinkoff.ru/";

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Бизнес'")
    void businessTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Бизнес'", () ->
                $x("//span/a/span[text()=\"Бизнес\"]/..").click());
        step("Проверка открытой вкладки", () ->
                $x("//p/nobr[text()=\"Онлайн-банк\"]").exists());
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Касса'")
    void kassaTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Касса'", () ->
                $x("//span/a/span[text()=\"Касса\"]/..").click());
        step("Проверка открытой вкладки", () ->
                $x("//p[contains(text(), \"Прием онлайн-платежей\")]").exists());
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Инвестиции'")
    void investTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Инвестиции'", () ->
                $x("//span/a/span[text()=\"Инвестиции\"]/..").click());
        step("Проверка открытой вкладки", () ->
                $x("//p[text()=\"Инвестируйте в ценные бумаги\"]").exists());
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Страхование'")
    void insuranceTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Страхование'", () ->
                $x("//span/a/span[text()=\"Страхование\"]/..").click());
        step("Проверка открытой вкладки", () ->
                $x("//p[text()=\"Электронное ОСАГО\"]").exists());
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Сим-карта'")
    void mobileTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Сим-карта'", () ->
                $x("//span/a/span[text()=\"Сим-карта\"]/..").click());
        step("Проверка открытой вкладки", () ->
                $x("//p[text()=\"Попробуйте бесплатно сим-карту Тинькофф\"]").exists());
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Путешествия'")
    void flightsTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Путешествия'", () ->
                $x("//span/a/span[text()=\"Путешествия\"]/..").click());
        step("Проверка открытой вкладки", () ->
                $x("//p[text()=\"Авиабилеты с кэшбэком до 7%\"]").exists());
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Развлечения'")
    void entertainmentTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Развлечения'", () ->
                $x("//span/a/span[text()=\"Развлечения\"]/..").click());
        step("Проверка открытой вкладки", () ->
                $x("//a/span/*[text()=\"Сегодня в кино\"]").exists());
    }
}
