package tests.web;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
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
                $(byText("Бизнес")).parent().click());
        step("Проверка открытой вкладки", () ->
                $(byText("Онлайн-банк")).should(Condition.exist));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Касса'")
    void kassaTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Касса'", () ->
                $(byText("Касса")).parent().click());
        step("Проверка открытой вкладки", () ->
                $(byText("Прием онлайн-платежей")).should(Condition.exist));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Инвестиции'")
    void investTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Инвестиции'", () ->
                $(byText("Инвестиции")).parent().click());
        step("Проверка открытой вкладки", () ->
                $(byText("Инвестируйте в ценные бумаги")).should(Condition.exist));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Страхование'")
    void insuranceTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Страхование'", () ->
                $(byText("Страхование")).parent().click());
        step("Проверка открытой вкладки", () ->
                $(byText("Электронное ОСАГО")).should(Condition.exist));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Сим-карта'")
    void mobileTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Сим-карта'", () ->
                $(byText("Сим-карта")).parent().click());
        step("Проверка открытой вкладки", () ->
                $(byText("Попробуйте бесплатно сим-карту Тинькофф")).should(Condition.exist));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Путешествия'")
    void flightsTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Путешествия'", () ->
                $(byText("Путешествия")).parent().click());
        step("Проверка открытой вкладки", () ->
                $(byText("Авиабилеты с кэшбэком до 7%")).should(Condition.exist));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Развлечения'")
    void entertainmentTabCheck() {
        step("Открытие главной страницы", () ->
                open(MAINPAGE));
        step("Открытие вкладки 'Развлечения'", () ->
                $(byText("Развлечения")).parent().click());
        step("Проверка открытой вкладки", () ->
                $(byText("Сегодня в кино")).should(Condition.exist));
    }
}
