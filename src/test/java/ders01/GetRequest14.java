package ders01;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest14 extends DummyBaseUrl {

    @Test
    public void test14(){
        spec02.pathParams("1","api","2","v1","3","employees");

        Response response=given().spec(spec02).when().get("/{1}/{2}/{3}");

        response.prettyPrint();

        //1)Status kodunun 200,
        Assert.assertEquals(200,response.statusCode());

        //2)10 dan büyük tüm id leri ekrana yazdırın ve 10 dan büyük 14 id olduğunu,

        JsonPath json =response.jsonPath();

        List<Integer> idList = json.getList("data.findAll{it.id>10}.id");

        System.out.println("id List : " + idList);

        //Groovy java platformu üzerinde çalışan bir bilgisayar dilidir..->"data.findAll{it.id>10}.id"
        //Groovy ile loop kullanmadan response dan gelen değerleri bir şarta göre alabiliriz

        //3)30 dan küçük tüm yaşları ekrana yazdırın ve bu yaşların en büyük yaşın 23 oldugunu

        List<Integer> yaşListesi=json.getList("data.findAll{it.employee_age<30}.employee_age");
        System.out.println("yaş listesi : " + yaşListesi);

        Collections.sort(yaşListesi);

        Assert.assertEquals(23,(int)yaşListesi.get(yaşListesi.size()-1));

        //4)maaşı 350000 den büyük olan tüm employee name leri ekrana yazdırın
        //ve bunların içerisinde "Charde Marshall" olduğunu test edin

        List<Integer> salaryList=json.getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println("salary List : " + salaryList);

        Assert.assertTrue(salaryList.contains("Charde Marshall"));

    }

}
