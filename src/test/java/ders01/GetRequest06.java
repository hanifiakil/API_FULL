package ders01;

import base_url.ReqresinBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest06 extends ReqresinBaseUrl {

    @Test
    public void test06(){

spec01.pathParams("parametre1","api","parametre2","users");

        Response response=given().spec(spec01).when().get("/{parametre1}/{parametre2}");

        response.prettyPrint();
//Matchers Class
        response.then().assertThat().body("data[4].email",equalTo("charles.morris@reqres.in"),
                                           "data[4].first_name",equalTo("Charles"));
        //JsonPath
        JsonPath json =response.jsonPath();

        System.out.println(json.getList("data.email"));

        System.out.println(json.getList("data.last_name"));

        Assert.assertEquals("charles.morris@reqres.in",json.getString("data[4].email"));
    }
}
