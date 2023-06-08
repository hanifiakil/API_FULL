package ders02;

import base_url.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
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

        //JSONObject te toString() kullanmalıyız   .body(expectedRequestData.toString())

        //4)doğrulama
        // JSON PATH

        JsonPath json =response.jsonPath();
        response.then().assertThat().statusCode(200);
        // TEST DATA İÇERİSİNDEKİ firstname                     , bady deki firstname
        Assert.assertEquals(expectedRequestData.getString("firstname"),json.getString("booking.firstname"));
        Assert.assertEquals(expectedRequestData.getString("lastname"),json.getString("booking.lastname"));
        Assert.assertEquals(expectedRequestData.getInt("totalprice"),json.getInt("booking.totalprice"));
        Assert.assertEquals(expectedRequestData.getBoolean("depositpaid"),json.getBoolean("booking.depositpaid"));

        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkin"),json.getString("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkout"),json.getString("booking.bookingdates.checkout"));

    }
}
