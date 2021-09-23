package tests.api.specs;

import config.models.UserJob;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;

public class Specs {
    static UserJob userjob = UserJob.builder()
            .name("morpheus")
            .job("leader")
            .build();

    public static RequestSpecification request = with()
            .contentType(JSON)
            .body(userjob);

    public static ResponseSpecification response = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .expectBody("name", is("morpheus"))
            .expectBody("job", is("leader"))
            .build();
}
