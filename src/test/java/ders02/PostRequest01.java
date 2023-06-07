package ders02;

import base_url.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import test_data.HerokuappTestData;

import static io.restassured.RestAssured.given;

public class PostRequest01 extends HerokuappBaseUrl {

/*
 {"firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
 */
    @Test
    public void test01(){
        //1)url oluştur
        spec05.pathParam("bir","booking");

        //2)expected data
        HerokuappTestData testData=new HerokuappTestData();
        JSONObject expectedRequestData=testData.setUpTestAndRequestData();
        System.out.println("expectedRequestData : "+expectedRequestData);
        //3)request ve response
        Response response=given().
                          contentType(ContentType.JSON).
                          auth().
                          basic("Admin","password123").
                          spec(spec05).
                          body(expectedRequestData.toString()).
                          when().
                          post("/{bir}");

        response.prettyPrint();

    }
}
