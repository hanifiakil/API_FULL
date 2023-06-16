package pojos;

public class BookingResponsePoje {
    /*
    "bookingid",11
          "booking":{
               "firstname","Ali"
               "lastname","Can"
               "totalprice",500
               "depositpaid",true
               "bookingdates":{
                       "checkin","2022-03-01"
                       "checkout","2022-03-11"
     */

    //1)private değişkenleri oluştur
    private int bookingid;
    private BookingPojo bookingPojo;

    //2)getter ve setter oluştur


    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBookingPojo() {
        return bookingPojo;
    }

    public void setBookingPojo(BookingPojo bookingPojo) {
        this.bookingPojo = bookingPojo;
    }

    //3)parametreli ve parametresiz constructor oluştur


    public BookingResponsePoje(int bookingid, BookingPojo bookingPojo) {
        this.bookingid = bookingid;
        this.bookingPojo = bookingPojo;
    }

    public BookingResponsePoje() {
    }

    //4)toString


    @Override
    public String toString() {
        return "BookingResponsePoje{" +
                "bookingid=" + bookingid +
                ", bookingPojo=" + bookingPojo +
                '}';
    }
}
