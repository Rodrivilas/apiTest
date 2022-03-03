package factoryRequestToken;

import factoryRequest.RequestInformation;
import io.restassured.response.Response;

public interface IRequestToken {

    Response send(RequestInformationToken requestInformation, String token);

}