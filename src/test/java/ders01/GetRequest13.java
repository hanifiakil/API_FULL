package ders01;

import base_url.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends GMIBankBaseUrl {

    @Test
    public void Test13(){
        //1)url oluştur

        spec03.pathParams("bir","tp-customers","iki",114351);

        //2)expected data oluştur

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("firstName","Della");
        expectedData.put("lastName","Heaney");
        expectedData.put("email","ricarda.larkin@yahoo.com");
        expectedData.put("mobilePhoneNumber","123-456-7893");
        System.out.printf("Expected Data : " + expectedData);


        //3)request ve response

        Response response=given()
                          .spec(spec03)
                          .header("Authorization","Bearer"+generateToken())
                          .when()
                          .get("/{bir}/{iki}");

        response.prettyPrint();

        //4)De-Serialization
        Map<String,Object> actualData =response.as(HashMap.class);
        System.out.println("actualData: " +actualData);

        //5)doğrulama

        Assert.assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
        Assert.assertEquals(expectedData.get("mobilePhoneNumber"),actualData.get("mobilePhoneNumber"));
        Assert.assertEquals(expectedData.get("email"),actualData.get("email"));
    }
}
