package ders03;

import base_url.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePoje;

import static io.restassured.RestAssured.given;

public class PostRequestPojo02 extends HerokuappBaseUrl {

    /*
    request body
    { "firstname","Ali"
    "lastname","Can"
    "totalprice",500
    "depositpaid",true
    "bookingdates":{
         "checkin","2022-03-01"
         "checkout","2022-03-11"
}}
Status code is 200
response body
{
"bookingid",11
  "booking":{"firstname","Ali"
    "lastname","Can"
    "totalprice",500
    "depositpaid",true
    "bookingdates":{
         "checkin","2022-03-01"
         "checkout","2022-03-11"
 }}}

     */

    @Test
    public void test(){

        //1)url oluştur
        spec05.pathParam("bir","booking");

        //2)expected data

        BookingDatesPojo bookingDates=new BookingDatesPojo("2022-03-01","2022-03-11");
        System.out.println("bookingDates = " + bookingDates);

        BookingPojo bookingPojo=new BookingPojo("Ali","Can",500,true,bookingDates);
        System.out.println("bookingPojo = " + bookingPojo);



        //3)request ve response
        Response response=given().contentType(ContentType.JSON).spec(spec05).
                auth().basic("admin","password123").
                body(bookingPojo).when().post("/{bir}");
        response.prettyPrint();

        //4)doğrulama
        BookingResponsePoje actualData = response.as(BookingResponsePoje.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200,response.getStatusCode());

        Assert.assertEquals(bookingPojo.getFirstname(),actualData.getBookingPojo().getFirstname());
        Assert.assertEquals(bookingPojo.getLastname(),actualData.getBookingPojo().getLastname());
        Assert.assertEquals(bookingPojo.getTotalprice(),actualData.getBookingPojo().getTotalprice());
        Assert.assertEquals(bookingPojo.isDepositpaid(),actualData.getBookingPojo().isDepositpaid());

        Assert.assertEquals(bookingDates.getCheckin(),actualData.getBookingPojo().getBookingDatesPojo().getCheckin());
        Assert.assertEquals(bookingDates.getCheckout(),actualData.getBookingPojo().getBookingDatesPojo().getCheckout());

    }
}
