package ders01;

import base_url.GMIBankBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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

        response.then().assertThat().body("firstName", equalTo("Della"),
                "lastName", equalTo("Heaney"),
                "mobilePhoneNumber",equalTo("123-456-7893"),
                "accounts[0].balance",equalTo(69700));

        //JSON PATH İLE

        JsonPath json =response.jsonPath();

        Assert.assertEquals("Della",json.getString("firstName"));
        Assert.assertEquals("Heaney",json.getString("lastName"));
        Assert.assertEquals(11190,json.getInt("accounts[1].balance"));



    }


}
