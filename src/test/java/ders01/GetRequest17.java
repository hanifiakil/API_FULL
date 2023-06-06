package ders01;

import base_url.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerokuappTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest17 extends HerokuappBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking/47

    {"firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
        1)JsonPhat
        2)De-Serialization
     */

    @Test
    public void test17(){
        //1)url oluştur

        spec05.pathParams("first","booking","second",47);

        //2) expected data oluştur
        HerokuappTestData expectedObje=new HerokuappTestData();
        HashMap<String,Object> expectedTestDataMab=expectedObje.setUpTestData();
        System.out.println("TEST DATA İÇİNDEKİ EXPECTED DATA : " +expectedTestDataMab);


        //3)REQUEST VE RESPONSE
        Response response=given().spec(spec05).when().get("/{first}/{second}");
        response.prettyPrint();

        //4)DOĞRULAMA
        //1. yol De-Serialization

        HashMap<String,Object> actualData = response.as(HashMap.class);//json formatını java formatına dönüştürme
        System.out.println("ACTUAL DATA" + actualData);

        Assert.assertEquals(expectedTestDataMab.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedTestDataMab.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(expectedTestDataMab.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(expectedTestDataMab.get("depositpaid"),actualData.get("depositpaid"));

        Assert.assertEquals(((Map)expectedTestDataMab.get("bookingdates")).get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)expectedTestDataMab.get("bookingdates")).get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));



    }
}
