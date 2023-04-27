package ders01;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetRequest02 {

    @Test
    public void test02(){

        String url="https://reqres.in/api/users";

        Response response = given().when().get(url);

        response.prettyPrint();//response deki bady i getirir

       // response.prettyPeek();//response deki herşeyi getirir

        //response.then().log().all();//response deki herşeyi getirir

        response.then().assertThat().statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");

        response.then().body("data[1].first_name", equalTo("Janet"),
                "data[1].last_name", equalTo("Weaver"),
                "data[1].email", equalTo("janet.weaver@reqres.in"));

    }
}
