package factoryRequest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestPOST implements IRequest {
    @Override
    public Response send(RequestInformation requestInformation) {

        Response response= given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .body(requestInformation.getBody())
                .log().all()
                .when()
                .post(requestInformation.getUrl());

        response.then().log().all();
        return response;
    }
}