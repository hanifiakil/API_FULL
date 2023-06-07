package test_data;

import org.json.JSONObject;

import java.util.HashMap;

public class HerokuappTestData {

    public HashMap<String,Object> setUpTestData(){

        HashMap<String,Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");
        HashMap<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates",bookingdates);

        return expectedData;

    }

    public JSONObject setUpTestAndRequestData(){

        JSONObject bookingdates =new JSONObject();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("firstname", "John");
        expectedRequest.put("lastname", "Smith");
        expectedRequest.put("totalprice", 111);
        expectedRequest.put("depositpaid", true);
        expectedRequest.put("bookingdates",bookingdates);

        return expectedRequest;

    }

}
