package tests;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
/*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */
    //1- Gonderecegimiz Request icin gerekli olan URl i ve ihtiyacimiz varsa Body i hazirla

    //2- Eger soruda bize verilmisse Expected Data hazirla

    //3- Bize dönen Response i Actual Data olarak kkaydet

    //4- Expected Data ile Actual Datanin karsilastirilmasi - Assertion

    @Test
    public void get01(){
        //1- Gonderecegimiz Request icin gerekli olan URl i ve ihtiyacimiz varsa Body i hazirla

        String url="https://restful-booker.herokuapp.com/booking/69";

        //2- Eger soruda bize verilmisse Expected Data hazirla


        //3- Bize dönen Response i Actual Data olarak kkaydet

        Response response = given().when().get(url);
        response.prettyPrint();

        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Content Type : "+response.getContentType());
        System.out.println("Server Header Value : "+response.getHeader("Server"));
        System.out.println("Status Line : "+response.getStatusLine());
        System.out.println("Response Time : "+response.getTime());
        //4- Expected Data ile Actual Datanin karsilastirilmasi - Assertion





    }






}
