package test_data;

import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyTestData {

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

    public HashMap<String, Object> setUpTestData() {
        List<Integer> yaşlar = new ArrayList<>();
        yaşlar.add(40);
        yaşlar.add(21);
        yaşlar.add(19);

        HashMap<String, Object> onuncu = new HashMap<>();
        onuncu.put("id", 10);
        onuncu.put("employee_name", "Sonya Frost");
        onuncu.put("employee_salary", 103600);
        onuncu.put("employee_age", 23);
        onuncu.put("profile_image", "");

        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("ondördüncüçalışan", "Haley Kennedy");
        expectedData.put("çalışansayısı", 24);
        expectedData.put("sondanüçüncüçalışanınmaaşı", 675000);
        expectedData.put("arananyaşlar", yaşlar);
        expectedData.put("onuncuçalışan", onuncu);
        return expectedData;

    }


/*
    dönen response un status kodunun 200 ve body kısmının aşagıdaki gibi olduğunu test edin
    {
        "status","success"
        "data","2"
        "message","Successfully! Record has been deleted"
    }
     */

    public JSONObject setUpDeleteExpectedData() {
        JSONObject expectedData = new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data","2");
        expectedData.put("message","Successfully! Record has been deleted");
   return expectedData;
    }
}