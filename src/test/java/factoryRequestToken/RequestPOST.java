package factoryRequestToken;

import factoryRequest.IRequest;
import factoryRequest.RequestInformation;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestPOST implements IRequestToken {
    @Override
    public Response send(RequestInformationToken requestInformation, String token) {

        Response response= given()
                .header("Token", token)
                .log().all()
                .when()
                .post(requestInformation.getUrl());

        response.then().log().all();
        return response;
    }
}