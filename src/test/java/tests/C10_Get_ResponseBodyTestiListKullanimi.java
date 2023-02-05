package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {
/*
            http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
            donen Response'in
            status code'unun 200,
            ve content type'inin Aplication.JSON,
            ve response body'sindeki
                employees sayisinin 24
                ve employee'lerden birinin "Ashton Cox"
                ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu test edin
            test edin.
     */

@Test
    public void get01(){
    //1- Gonderecegimiz Request icin gerekli olan URl i ve ihtiyacimiz varsa Body i hazirla
    String url="http://dummy.restapiexample.com/api/v1/employees";
    //2- Eger soruda bize verilmisse Expected Data hazirla

    //3- Bize dönen Response i Actual Data olarak kkaydet
    Response response=given().when().get(url);
    response.prettyPrint();
    System.out.println(response.getStatusCode());
    //4- Expected Data ile Actual Datanin karsilastirilmasi - Assertion
    response.
            then().
            assertThat().
            statusCode(200).contentType("Aplication.JSON").
            body("data.id", hasSize(24),
             "data.employee_name",hasItem("Ashton Cox"),
             "data.employee_age",hasItems(61,40,30));


}






}
