package tests;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import testData.testDatajsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
/*

https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
request yolladigimizda donen response'in status kodunun 200 ve
response body'sinin asagida verilen ile ayni oldugunu test ediniz

 Response body :
  {
  "userId":3,
  "id":22,
  "title":"dolor sint quo a velit explicabo quia nam",
  "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
  }
   */

@Test
    public void get01(){
    //1_Url i hazirla

    specJsonPlace.pathParams("pp1","posts","pp2",22);
    //2_ Expected Data Olustur
    testDatajsonPlaceHolder testDatajsonPlaceHolder=new testDatajsonPlaceHolder();

    JSONObject expectedData=testDatajsonPlaceHolder.expectedBodyOlusturJSON();

    //3-Responsu Kaydet
    Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
    response.prettyPrint();
    // Assertion
    JsonPath resJPath=response.jsonPath();

    Assert.assertEquals(testDatajsonPlaceHolder.basariliStatusKodu,response.getStatusCode());
    Assert.assertEquals(expectedData.get("userId"),resJPath.get("userId"));
    Assert.assertEquals(expectedData.get("id"),resJPath.get("id"));
    Assert.assertEquals(expectedData.get("title"),resJPath.get("title"));
    Assert.assertEquals(expectedData.get("body"),resJPath.get("body"));

}



}
