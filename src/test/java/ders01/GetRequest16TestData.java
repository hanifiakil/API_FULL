package ders01;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest16TestData extends JsonPlaceHolderBaseUrl {
    @Test
    public void test16(){

        //1)url oluştur
        spec04.pathParams("1","todos","2",2);

        //2) expected data oluşturma
        JsonPlaceHolderTestData expectedDataObje =new JsonPlaceHolderTestData();
        HashMap<String,Object> expectedData = (HashMap<String,Object>) expectedDataObje.setUpTestData();
        System.out.println("TEST DATA NIN İÇİNDEKİ EXPECTED DATA : " + expectedData);

        //3)request ve response

        Response response =given().spec(spec04).when().get("/{1}/{2}");
        response.prettyPrint();

        //4)Doğrulama

        //1.yol matchers class

        response.then().assertThat().statusCode((Integer)expectedData.get("statusCode")).
                headers("via",equalTo(expectedData.get("via")),
                        "Server",equalTo(expectedData.get("Server")))
                .body("userId",equalTo(expectedData.get("userId")),
                        "title",equalTo(expectedData.get("title")),
                        "completed",equalTo(expectedData.get("completed")));


        //2. yol json path

        JsonPath json = response.jsonPath();
        Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
        Assert.assertEquals(expectedData.get("via"),response.getHeader("via"));
        Assert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));
        Assert.assertEquals(expectedData.get("userId"),json.getInt("userId"));
        Assert.assertEquals(expectedData.get("title"),json.getString("title"));
        Assert.assertEquals(expectedData.get("completed"),json.getBoolean("completed"));


        //3. yol de-serialiazation

        HashMap<String,Object> actualData =response.as(HashMap.class);
        System.out.println(actualData);

        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));

    }
}
