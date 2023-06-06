package test_data;

import java.util.HashMap;

public class HerokuappTestData {

    public HashMap<String,Object> setUpTestData(){

        HashMap<String,Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");
        HashMap<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstname", "Jane");
        expectedData.put("lastname", "Doe");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates",bookingdates);

        return expectedData;

    }

}
