package ders01;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetRequest15 extends JsonPlaceHolderBaseUrl {

    @Test
    public void test15(){

        //1)url oluştur

        spec04.pathParams("bir","todos","iki",2);

        //2)expected data oluştur

        HashMap<String,Object> expecdetData = new HashMap<>();
        expecdetData.put("statusCode",200);
        expecdetData.put("completed",false);
        expecdetData.put("userId",1);
        expecdetData.put("via","1.1 vegur");
        expecdetData.put("title","quis ut nam facilis et officia qui");
        expecdetData.put("Server","cloudflare");

        //3)request ve response

        Response response =given().spec(spec04).when().get("/{bir}/{iki}");
        response.prettyPrint();
       // response.prettyPeek();

        //4)doğrulama

        //1. yol matchers class

        response.then().assertThat()
                .statusCode((Integer) expecdetData.get("statusCode"))
                .headers("via",equalTo(expecdetData.get("via")),
                        "Server",equalTo(expecdetData.get("Server")))
                .body("userId",equalTo(expecdetData.get("userId")),
                        "title",equalTo(expecdetData.get("title")),
                        "completed",equalTo(expecdetData.get("completed")));


        //2. yol json path

        JsonPath json = response.jsonPath();
        Assert.assertEquals(expecdetData.get("statusCode"),response.statusCode());
        Assert.assertEquals(expecdetData.get("via"),response.getHeader("via"));
        Assert.assertEquals(expecdetData.get("Server"),response.getHeader("Server"));
        Assert.assertEquals(expecdetData.get("userId"),json.getInt("userId"));
        Assert.assertEquals(expecdetData.get("title"),json.getString("title"));
        Assert.assertEquals(expecdetData.get("completed"),json.getBoolean("completed"));


        //3. yol de-serialiazation

        HashMap<String,Object> actualData =response.as(HashMap.class);
        System.out.println(actualData);

        Assert.assertEquals(expecdetData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expecdetData.get("title"),actualData.get("title"));
        Assert.assertEquals(expecdetData.get("completed"),actualData.get("completed"));
    }
}
