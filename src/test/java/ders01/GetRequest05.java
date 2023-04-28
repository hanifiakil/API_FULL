package ders01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest05 {
    @Test
    public void test05(){

        String url = "https://jsonplaceholder.typicode.com/todos/123";

        Response response = given().when().get(url);

        response.prettyPrint();

        response.then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .header("Server", equalTo("cloudflare"))
                .body("userId", equalTo(7),
                        "title", equalTo("esse et quis iste est earum aut impedit"),
                        "completed", equalTo(false));

    }
}
