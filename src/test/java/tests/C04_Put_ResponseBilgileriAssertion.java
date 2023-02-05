package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssertion {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
                }
        donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK
      */
@Test
    public void put(){
    //1- Gonderecegimiz Request icin gerekli olan URl i ve ihtiyacimiz varsa Body i hazirla
    String url="https://jsonplaceholder.typicode.com/posts/70";
    JSONObject body=new JSONObject();
    body.put("title","Ahmet");
    body.put("body","Merhaba");
    body.put("userId",10);
    body.put("id",70);
    //2- Eger soruda bize verilmisse Expected Data hazirla

    //3- Bize dönen Response i Actual Data olarak kkaydet
    Response response=given().
                      contentType(ContentType.JSON).
                      when().
                      body(body.toString()).
                      put(url);

    response.prettyPrint();
    //4- Expected Data ile Actual Datanin karsilastirilmasi - Assertion
    response.
            then().
            assertThat().
            statusCode(200).
            contentType("application/json; charset=utf-8").
            header("Server","cloudflare").
            statusLine("HTTP/1.1 200 OK");

}



}
