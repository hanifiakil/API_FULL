package ders01;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class GetRequest12 extends JsonPlaceHolderBaseUrl {

    @Test
    public void test12(){
        //1)URL OLUŞTURMA
        spec04.pathParams("bir","todos","iki",7);

        //2) EXPECTED(BEKLENEN) DATA OLUŞTUR

        Map<String, Object> expectedData= new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",7);
        expectedData.put("title","illo expedita consequatur quia in");
        expectedData.put("completed",false);

        System.out.println("expected data : " +expectedData);

        //3)REQUEST VE RESPONSE

       Response response= given().spec(spec04).when().get("/{bir}/{iki}");

        //"/{bir}/{iki}" => adrese /todos/7 ekle demek

        response.prettyPrint();

        //DATA YI JSON DAN->JAVA YA DÖNÜŞTÜRMEYE De-Serialization
        //DATA YI JAVA DAN->JSON A DÖNÜŞTÜRMEYE Serialization denir

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("ACTUAL DATA : "+ actualData);

        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("complated"),actualData.get("complated"));



    }
}
