package ders01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;

public class GetRequest10 extends Authentication {

    //Authenticatio Class ın içerisindeki generatToken() method u kullanılacak

    String endPoint = "http://gmibank.com/api/tp-customers";

    @Test
    public void test10(){

        Response response =given().
                header("Authorization","Bearer "+generateToken()).
                when().
                get(endPoint).
                then().
                extract().
                response();
        response.prettyPeek();

        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);


    }
}
