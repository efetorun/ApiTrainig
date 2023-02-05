package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {
        /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
*/


@Test
public void jsonObje01(){
    JSONObject ilkJsonObje=new JSONObject();

    ilkJsonObje.put("title","Ahmet");
    ilkJsonObje.put("body","Merhaba");
    ilkJsonObje.put("userId",1);

    System.out.println(ilkJsonObje.toString());

}
@Test
    public void jsonObje02(){
     /*
                Asagidaki JSON Objesini olusturup konsolda yazdirin.
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */
    JSONObject innerObject=new JSONObject();
    innerObject.put("checkin","2018-01-01");
    innerObject.put("checkout","2019-01-01");

    JSONObject body=new JSONObject();
    body.put("firstname","Jim");
    body.put("additionalneeds","Breakfast");
    body.put("bookingdates",innerObject);
    body.put("totalprice",111);
    body.put("depositpaid",true);
    body.put("lastname","Brown");

    System.out.println(body.toString());

}

}
