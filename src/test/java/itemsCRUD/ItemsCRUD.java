package itemsCRUD;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ItemsCRUD {
    @Test
    public void crudItem(){
        // Create
        JSONObject body = new JSONObject();
        body.put("Content","LucianoItem");

        Response response=given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body(body.toString())
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("LucianoItem"))
                .log().all();

        int idProject =response.then().extract().path("Id");

        // Read
        response=given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .log().all()
                .when()
                .get("https://todo.ly/api/items/"+idProject+".json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("LucianoItem"))
                .log().all();
        // Update
        body.put("Content","LucianoUpdate");

        response=given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body(body.toString())
                .log().all()
                .when()
                .put("https://todo.ly/api/items/"+idProject+".json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("LucianoUpdate"))
                .log().all();
        // Delete
        response=given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .log().all()
                .when()
                .delete("https://todo.ly/api/items/"+idProject+".json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("LucianoUpdate"))
                .body("Deleted",equalTo(true))
                .log().all();
    }
}