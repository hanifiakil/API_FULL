package ders01;

import base_url.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest11 extends GMIBankBaseUrl {

    @Test
    public void test11(){
        spec03.pathParams("bir","tp-customers","iki","114351");

        Response response=given()
                .spec(spec03)
                .header("Authorization","Bearer "+generateToken())
                .when()
                .get("/{bir}/{iki}");
        response.prettyPrint();

        //MATCHERS CLASS İLE




        //JSON PATH İLE
    }


}
