package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTests extends WebTestBase {

    static final String MAINPAGE = "https://www.tinkoff.ru/";

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Бизнес'")
    void businessTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Бизнес")).click();
        $(".ab2Bjtnqb.cb2Bjtnqb p").shouldHave(text("Онлайн-банк для малого бизнеса"));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Касса'")
    void kassaTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Касса")).click();
        $(".ablkGIjod p").shouldHave(text("Прием онлайн-платежей для вашего бизнеса"));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Инвестиции'")
    void investTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Инвестиции")).click();
        $(".cb2Bjtnqb p").shouldHave(text("Инвестируйте в ценные бумаги"));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Страхование'")
    void insuranceTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Страхование")).click();
        $(".abxM36M2S p").shouldHave(text("Электронное ОСАГО"));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Сим-карта'")
    void mobileTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Сим-карта")).click();
        $(".cb2Bjtnqb p").shouldHave(text("Попробуйте бесплатно связь от Тинькофф"));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Путешествия'")
    void flightsTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Путешествия")).click();
        $(".ab3aYWpp_ p").shouldHave(text("Авиабилеты с кэшбэком до 7%"));
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка вкладки 'Развлечения'")
    void entertainmentTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Развлечения")).click();
        $(".PageHeader__linkWrapper_d1NUMT").shouldHave(text("Сегодня в кино"));
    }

}
