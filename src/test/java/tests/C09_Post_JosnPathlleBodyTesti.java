package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Post_JosnPathlleBodyTesti {
    /*
                https://restful-booker.herokuapp.com/booking
                 url’ine asagidaki body'ye sahip
                bir POST request gonderdigimizde
                           {
                                "firstname" : "Ali",
                                "lastname" : "Bak",
                                "totalprice" : 500,
                                "depositpaid" : false,
                                "bookingdates" : {
                                    "checkin" : "2021-06-01",
                                    "checkout" : "2021-06-10"
                                },
                                "additionalneeds" : "wi-fi"
                            }
                donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Ali",
                    ve "lastname“in, "Bak",
                    ve "totalprice“in,500,
                    ve "depositpaid“in,false,
                    ve "checkin" tarihinin 2021-06-01
                    ve "checkout" tarihinin 2021-06-10
                    ve "additionalneeds“in,"wi-fi"
                oldugunu test edin
         */
    @Test
    public void post01() {
        //1- Gonderecegimiz Request icin gerekli olan URl i ve ihtiyacimiz varsa Body i hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody = new JSONObject();
        innerBody.put("checkin" , "2021-06-01");
        innerBody.put("checkout" ,"2021-06-10");

        JSONObject body = new JSONObject();
        body.put("firstname", "Ali");
        body.put("lastname", "Bak");
        body.put("totalprice", 500);
        body.put("depositpaid", false);
        body.put("bookingdates", innerBody);
        body.put("additionalneeds" , "wi-fi");


        //2- Eger soruda bize verilmisse Expected Data hazirla

        //3- Bize dönen Response i Actual Data olarak kaydet

        Response response=given().
                contentType(ContentType.JSON).
                when().
                body(body.toString()).
                post(url);

        response.prettyPrint();

        //4- Expected Data ile Actual Datanin karsilastirilmasi - Asse

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                body("booking.firstname", equalTo("Ali"),
                "booking.lastname",equalTo("Bak"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.additionalneeds",equalTo("wi-fi"),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"),
                        "booking.checkout",equalTo(null));

    }
}