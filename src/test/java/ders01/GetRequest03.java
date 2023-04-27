package ders01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetRequest03 {

    @Test
    public void test03(){

        String url="https://restful-booker.herokuapp.com/booking/7";

        Response response = given().when().get(url);

        response.prettyPrint();

        response.then().contentType(ContentType.JSON).statusCode(200);


        response.then().assertThat().body("firstname", equalTo("Mark"),
                                           "lastname",equalTo("Brown"),
                                           "totalprice",equalTo(867),
                                            "depositpaid",equalTo(false));

    }
}
