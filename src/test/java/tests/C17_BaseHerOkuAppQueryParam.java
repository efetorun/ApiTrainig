package tests;

import baseURL.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseHerOkuAppQueryParam extends HerokuAppBaseUrl {

    //  Class icinde 3 Test Methodo olusuturun ve asagidaki testleri yapin
    //  Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    /*
        1-https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 33071 id'ye sahip bir booking oldugunu test edin
     */

    /*
        2-https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */

    /*
        3-https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

    @Test
    public void get01(){
        //url i hazirlaz
        //1- Url i hazirla

        specHerokuApp.pathParam("pp1","booking");

        //2- Expected Data Hazirla

        //3- Response i kaydet

        Response response=given().
                          spec(specHerokuApp).
                          when().
                          get("/{pp1}");
        //4_Assertion
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(2789));



    }
    @Test
    public void get02(){
    //Url i hazirla
        specHerokuApp.pathParam("pp1","booking").queryParam("firstname","Eric");
        //Expected Data Hazirla

        // Response kaydet
        Response response=given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();
        //Assertion
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(1));
    }
    @Test
    public void get03(){
//Url i hazirla
        specHerokuApp.pathParam("pp1","booking").queryParams("firstname","Jim","lastname","Jackson");
        //Expected Data Hazirla
        //Response u kaydet
        Response response=given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(0));

    }
}
