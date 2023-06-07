package ders01;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest18 extends DummyBaseUrl {

    /*
    "https://dummy.restapiexample.com/api/v1/employees" url ine bir istek gönderildiğinde
    status kodun 200 olduğunu
    14. çalışan isminin "Haley Kennedy" olduğunu
    çalışan sayısının 24 olduğunu
    sondan 3. çalışanın maaşının 675000 olduğunu
    40,21 ve 19 yaşlarında çalışanlar olup olmadığını
    10. çalışan bilgilerinin aşagıdaki gibi

    {
    "id": 10,
            "employee_name": "Sonya Frost",
            "employee_salary": 103600,
            "employee_age": 23,
            "profile_image": ""
            }
            olduğunu test edin
     */

    @Test
    public void test18(){
        //1)url oluştur
        spec02.pathParams("bir","api","iki","v1","üç","employees");

        //2)expected data oluştur
        DummyTestData expectedObje = new DummyTestData();
        Map<String,Object> expectedTestDataMap = expectedObje.setUpTestData();
        System.out.println("EXPECTED TEST DATA : "+ expectedTestDataMap);

        //3)REQEST VE RESPONSE OLUŞTURMA
        Response response=given().spec(spec02).when().get("/{bir}/{iki}/{üç}");
        response.prettyPrint();

        //4)DOĞRULAMA
        //1. YOL De-Serialization

        HashMap<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println("ACTUAL DATA MAP : " + actualDataMap);

        // status kodun 200 olduğunu
        Assert.assertEquals(expectedTestDataMap.get("statusCode"),response.getStatusCode());

        //14. çalışan isminin "Haley Kennedy" olduğunu
        Assert.assertEquals(expectedTestDataMap.get("ondördüncüçalışan"),
                ((Map)((List)actualDataMap.get("data")).get(13)).get("employee_name"));

        //çalışan sayısının 24 olduğunu
        Assert.assertEquals(expectedTestDataMap.get("çalışansayısı"),((List<?>) actualDataMap.get("data")).size());

        //sondan 3. çalışanın maaşının 675000 olduğunu
        Assert.assertEquals(expectedTestDataMap.get("sondanüçüncüçalışanınmaaşı"),
                ((Map)((List)actualDataMap.get("data")).get(((List<?>) actualDataMap.get("data")).size()-3)).get("employee_salary"));


        //40,21 ve 19 yaşlarında çalışanlar olup olmadığını
        List<Integer> actualYaşListesi = new ArrayList<>();

        for (int i=0; i<24 ; i++){
        actualYaşListesi.add((Integer) ((Map)((List<?>) actualDataMap.get("data")).get(i)).get("employee_age"));
    }
    Assert.assertTrue(actualYaşListesi.containsAll((Collection<?>) expectedTestDataMap.get("arananyaşlar")));
    }
}
