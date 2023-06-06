package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String,Object> setUpTestData() {

        HashMap<String,Object> expecdetData = new HashMap<>();
        expecdetData.put("statusCode",200);
        expecdetData.put("completed",false);
        expecdetData.put("userId",1);
        expecdetData.put("via","1.1 vegur");
        expecdetData.put("title","quis ut nam facilis et officia qui");
        expecdetData.put("Server","cloudflare");
        return expecdetData;


    }
}
