package tests.api;

import annotations.Layer;
import config.models.User;
import config.models.UserJob;
import config.models.UserLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.specs.Specs;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.api.specs.Specs.request;
import static tests.api.specs.Specs.response;

@Layer("Api")
@Owner("Paleev O.")
@Feature("Действия с пользователем")
public class ReqresTests {
    @Test
    @Tag("api")
    @DisplayName("Получение имени пользователя")
    public void getUsersFirstName() {
        User janet = given()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .extract().as(User.class);
        assertEquals("Janet", janet.getUserData().getFirst_name());
    }

    @Test
    @Tag("api")
    @DisplayName("Cоздание пользователя")
    public void createUser() {
        given()
                .spec(request)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .spec(response);
    }

    @Test
    @Tag("api")
    @DisplayName("Обновление пользователя")
    public void updateUser() {
        String response =
                given()
                        .spec(request)
                        .when()
                        .post("https://reqres.in/api/users")
                        .then()
                        .spec(Specs.response)
                        .extract().path("id");
        UserJob newjob = UserJob.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        given()
                .contentType(JSON)
                .body(newjob)
                .when()
                .put("https://reqres.in/api/users/" + response)
                .then()
                .statusCode(200)
                .body("name", is("morpheus"), "job", is("zion resident"));
    }

    @Test
    @Tag("api")
    @DisplayName("Удаление пользователя")
    public void deleteUser() {
        String response =
                given()
                        .spec(request)
                        .when()
                        .post("https://reqres.in/api/users")
                        .then()
                        .spec(Specs.response)
                        .extract().path("id");
        given()
                .delete("https://reqres.in/api/users/" + response)
                .then()
                .statusCode(204);
    }

    @Test
    @Tag("api")
    @DisplayName("Ошибка при авторизации без пароля")
    public void unsuccessfulLogin() {
        UserLogin missPass = UserLogin.builder()
                .email("morpheus@zion.com")
                .build();
        String response =
                given()
                        .contentType(JSON)
                        .body(missPass)
                        .when()
                        .post("https://reqres.in/api/login")
                        .then()
                        .statusCode(400)
                        .extract().path("error");
        assertEquals("Missing password", response);
    }

    @Test
    @Tag("api")
    @DisplayName("Поиск пользователя")
    public void userSearchWithGroovy() {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.findAll{it.email =~/.*?son@reqres.in/}.first_name.flatten()",
                        hasItem("Lindsay"));
    }
}