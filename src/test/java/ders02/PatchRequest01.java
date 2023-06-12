package ders02;

import base_url.JsonPlaceHolderBaseUrl;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

public class PatchRequest01 extends JsonPlaceHolderBaseUrl {

    /*
   "title","Batch44"

   dönen response un status kodunun 200 ve bady kısmının aşağıdaki gibi olduğunu test edin

   "userId",10
   "title","Batch44"
   "completed",true
   "id",198
     */
    @Test
    public void test(){

        //1)url oluştur

        spec04.pathParams("first","todos","secand",198);

        //2)expected data

        JsonPlaceHolderTestData testData =new JsonPlaceHolderTestData();
        JSONObject requestData =testData.setUpPatchRequestData();
        System.out.println("requestData = " + requestData);

        //3)request ve response

        //4)doğrulama

    }
}
