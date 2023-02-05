package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataVeJsonPathIleAssertion {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void get(){
        //1- Gonderecegimiz Request icin gerekli olan URl i ve ihtiyacimiz varsa Body i hazirla
        String url="http://dummy.restapiexample.com/api/v1/employee/3";


        //2- Eger soruda bize verilmisse Expected Data hazirla
        JSONObject innerBody=new JSONObject();
        innerBody.put("id",3);
        innerBody.put("employee_name","Ashton Cox");
        innerBody.put("employee_salary",86000);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");

        JSONObject expbody=new JSONObject();

        expbody.put("status","success");
        expbody.put( "message","Successfully! Record has been fetched.");
        expbody.put("data",innerBody);
        //3- Bize dönen Response i Actual Data olarak kkaydet
        Response response=given().when().get(url);
        response.prettyPrint();
        //4- Expected Data ile Actual Datanin karsilastirilmasi - Assertion
        JsonPath resJPath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resJPath.get("status"),expbody.get("status"));
        softAssert.assertEquals(resJPath.get("status"),expbody.get("status"));
        softAssert.assertEquals(resJPath.get("data.id"),expbody.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJPath.get("data.employee_salary"),expbody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJPath.get("data.employee_name"),expbody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJPath.get("data.employee_age"),expbody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJPath.get("data.profile_image"),expbody.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();


    }





}
