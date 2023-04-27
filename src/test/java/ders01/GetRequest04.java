package ders01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest04 {

    @Test
    public void test04(){

        String url="https://dummy.restapiexample.com/api/v1/employees";

        Response response = given().when().get(url);

        response.prettyPrint();

        response.then().contentType(ContentType.JSON).statusCode(200);

        response.then().assertThat().body("data", Matchers.hasSize(24),
                                           "data.employee_name",Matchers.hasItem("Ashton Cox"),
                                            "data.employee_age",Matchers.hasItems(21,61,23));
    }
}
