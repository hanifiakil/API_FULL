package ders02;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends JsonPlaceHolderBaseUrl {

    /*
   "title","Batch44"

   dönen response un status kodunun 200 ve bady kısmının aşağıdaki gibi olduğunu test edin

   "userId",10
   "title","Batch44"
   "completed",true
   "id",198
     */
    @Test
    public void test(){

        //1)url oluştur

        spec04.pathParams("first","todos","secand",198);

        //2)expected data

        JsonPlaceHolderTestData testData =new JsonPlaceHolderTestData();
        JSONObject requestData =testData.setUpPatchRequestData();
        System.out.println("requestData = " + requestData);

        JSONObject expectedData =testData.setUpPatchExpectedData();
        System.out.println("expectedData = " + expectedData);


        //3)request ve response
        Response response=given().contentType(ContentType.JSON).spec(spec04)
                           .body(requestData.toString()).when()
                           .patch("/{first}/{secand}");

        //4)doğrulama

        //1)JSonPath
        JsonPath json =response.jsonPath();
        Assert.assertEquals(expectedData.get("userId"),json.getInt("userId"));
        Assert.assertEquals(expectedData.get("id"),json.getInt("id"));
        Assert.assertEquals(expectedData.get("title"),json.getString("title"));
        Assert.assertEquals(expectedData.get("completed"),json.getBoolean("completed"));


        //2) de-serialization
        HashMap<String,Object> actualData =response.as(HashMap.class);
        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));
        Assert.assertEquals(expectedData.get("id"),actualData.get("id"));

    }
}
