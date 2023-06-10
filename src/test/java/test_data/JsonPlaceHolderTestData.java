package test_data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> setUpTestData() {

        HashMap<String, Object> expecdetData = new HashMap<>();
        expecdetData.put("statusCode", 200);
        expecdetData.put("completed", false);
        expecdetData.put("userId", 1);
        expecdetData.put("via", "1.1 vegur");
        expecdetData.put("title", "quis ut nam facilis et officia qui");
        expecdetData.put("Server", "cloudflare");
        return expecdetData;

    }

    /*
    "userId":55,
    "title":"Tidy your room"
    "completed":false

     */
    public JSONObject setUpPostData() {
        JSONObject expectedRequest =new JSONObject();
        expectedRequest.put("userId",55);
        expectedRequest.put("title","Tidy your room");
        expectedRequest.put("completed",false);
        expectedRequest.put("statusCode",201);
        expectedRequest.put("id",201);
        return expectedRequest;

    }
}