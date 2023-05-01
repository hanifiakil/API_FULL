package ders01;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest08 extends DummyBaseUrl {

    @Test
    public void test08(){

        spec02.pathParams("birinci","api"
                ,"ikinci","v1"
                ,"üçüncü","employees"
                ,"dördüncü","12");

        Response response=given().spec(spec02).when().get("{/birinci}/{ikinci}/{üçüncü}/{dördüncü}");
response.prettyPrint();
        //MATCHERS CLASS İLE

        response.then().statusCode(200).contentType(ContentType.JSON)
                .body("data.employee_name",equalTo("Quinn Flynn"));

        //JSON PATH

        JsonPath json=response.jsonPath();
        System.out.println(json.getString("data.employee_name"));

        Assert.assertEquals("Quinn Flynn",json.getString("data.employee_name"));


    }
}
