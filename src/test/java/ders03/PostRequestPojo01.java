package ders03;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;

public class PostRequestPojo01 extends JsonPlaceHolderBaseUrl {
    /*request gönderildiğinde
    Request body{
    "userId",21
    "id",201
    "title","Tidy your room"
    "completed",false
    }
    Status kodun 201,response body nin ise
    {
    "userId",21
    "id",201
    "title","Tidy your room"
    "completed",false
    }
     */

    @Test
    public void test(){
        //1)url oluştur
        spec04.pathParam("first","todos");

        //2)Expected data oluştur
        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(21,201,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //3)Request ve Response
        Response response=given().contentType(ContentType.JSON).spec(spec04).
                body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //4)doğrulama
        //De-Serialization

        JsonPlaceHolderPojo actuvalData = response.as(JsonPlaceHolderPojo.class);

        Assert.assertEquals(201,response.getStatusCode());
        Assert.assertEquals(expectedData.getId(),actuvalData.getId());
        Assert.assertEquals(expectedData.getUserId(),actuvalData.getUserId());
        Assert.assertEquals(expectedData.getTitle(),actuvalData.getTitle());
        Assert.assertEquals(expectedData.isCompleted(),actuvalData.isCompleted());

    }
}
