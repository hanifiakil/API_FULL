package ders01;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest07 extends DummyBaseUrl {

    @Test
    public void test07(){
spec02.pathParams("first","api","second","v1","third","employees");
//"https://dummy.restapiexample.com"
        Response response=given().spec(spec02).when().get("/{first}/{second}/{third}");
        // "/{first}/{second}/{third}"=> /api/v1/employees denilmek istenmiştir

        response.prettyPrint();

        //bütün çalışanların isimlerini yazdıralım

        JsonPath json=response.jsonPath();
        System.out.printf(json.getString("data.employee_name"));

        // 3. çalışanın ismini konsola yazdırın
        System.out.printf(json.getString("data[2].employee_name"));

        //ilk 5 çalışanın adını konsola yazdırınız
        for (int i=0;i<5;i++){
            System.out.println(i+1 + ". çalışan : " + json.getString("data[" + i +"].employee_name"));
        }
        //2. yol

        System.out.printf(json.getString("data.employee_name[0,1,2,3,4]"));
        //en son çalışanın adını konsola yazdırın

        System.out.println(json.getString("data.employee_name[-1]"));


    }
}
