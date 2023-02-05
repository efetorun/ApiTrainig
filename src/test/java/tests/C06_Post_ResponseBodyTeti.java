package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Post_ResponseBodyTeti {
     /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */
@Test
    public void post01(){
    //1- Gonderecegimiz Request icin gerekli olan URl i ve ihtiyacimiz varsa Body i hazirla
    String url="https://jsonplaceholder.typicode.com/posts";

    JSONObject reqBody=new JSONObject();
    reqBody.put("title","API");
    reqBody.put("body","API ogrenmek ne guzel");
    reqBody.put("userId",10);
    System.out.println(reqBody.toString());
    //2- Eger soruda bize verilmisse Expected Data hazirla

    //3- Bize dönen Response i Actual Data olarak kaydet
    Response resBody=given().
            contentType(ContentType.JSON).
            when().
            body(reqBody.toString()).
            post(url);
    resBody.prettyPrint();
    //4- Expected Data ile Actual Datanin karsilastirilmasi - Assertion
    resBody.
            then().
            assertThat().
            contentType("application/json").
            statusCode(201).
            body("title", Matchers.equalTo("API")).
            body("userId",Matchers.lessThan(100)).
            body("body",Matchers.containsString("API"));

}

}
