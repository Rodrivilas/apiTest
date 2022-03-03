package factoryRequestToken;

import factoryRequest.IRequest;
import factoryRequest.RequestInformation;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestGETToken implements IRequestToken {
    @Override
    public Response send(RequestInformationToken requestInformation, String token) {

        Response response= given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .log().all()
                .when()
                .get(requestInformation.getUrl());

        response.then().log().all();
        return response;
    }
}