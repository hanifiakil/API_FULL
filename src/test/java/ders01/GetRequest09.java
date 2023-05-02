package ders01;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest09 {
// şifreli kısım olduğundan dolayı çalışmıyor

    String endPoint = "http://gmibank.com/api/tp-customers";
    String bearerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDQ0YXBpIiwiYXV0aCI6IlJPTEVfQ1VTVE9NRVIiLCJleHAiOjE2ODMxMTc5NTR9.Pgrx6M3krKbT0SU4pjmQLb1F88x6v5V-f_Kpr-qqjdH0NxzbKnyR334otUUysOy-tkRWfIlkFYP5ejtcoiKpVA";

    @Test
    public void test(){
        Response response =given().
                header("Authorization","Bearer " + bearerToken).
                when().get(endPoint).then().extract().response();

        response.prettyPrint();
    }
}
