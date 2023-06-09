package pojos;

public class BookingDatesPojo {
    /*
    "bookingdates":{
         "checkin","2022-03-01"
         "checkout","2022-03-11"
     */
   // 1)private değişkenini oluştur
    private  String checkin;
    private String checkout;

    //2)getter ve setter oluştur

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    //3) parametreli ve parametresiz constructor oluştur

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

    //4)toString

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }

}
