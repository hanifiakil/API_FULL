package ders02;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DeleteRequest extends DummyBaseUrl {
    /*
    dönen response un status kodunun 200 ve body kısmının aşagıdaki gibi olduğunu test edin
    {
    "status","success"
    "data","2"
    "message","Successfully! Record has been deleted"
    }
     */
    @Test
    public void test() {

        //1)url oluştur

        spec02.pathParams("bir", "api", "iki", "v1", "üç", "delete", "dört",2);

        //2)expected data

        DummyTestData testData = new DummyTestData();
        JSONObject expectedData = testData.setUpDeleteExpectedData();
        System.out.println("expectedData = " + expectedData);


        //3)request ve response
        Response response = given().spec(spec02)
                .body(expectedData.toString()).when()
                .delete("/{bir}/{iki}/{üç}/{dört}");

        //4)doğrulama

        //1)JSonPath
        JsonPath json = response.jsonPath();
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(expectedData.get("status"), json.get("status"));
        Assert.assertEquals(expectedData.get("data"), json.get("data"));
        Assert.assertEquals(expectedData.get("message"), json.get("message"));


        //2) de-serialization
        HashMap<String, Object> actualData = response.as(HashMap.class);
        Assert.assertEquals(expectedData.get("status"), actualData.get("status"));
        Assert.assertEquals(expectedData.get("data"), actualData.get("data"));
        Assert.assertEquals(expectedData.get("message"), actualData.get("message"));

    }
}