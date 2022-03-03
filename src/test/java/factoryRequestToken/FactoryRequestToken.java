package factoryRequestToken;

public class FactoryRequestToken {

    public static IRequestToken make(String methodRequest) {
        IRequestToken request;
        switch (methodRequest.toLowerCase()) {

            case "getToken":
                request = new RequestGETToken();
                break;
            case "post":
                request = new RequestPOST();
                break;
            case "put":
                request = new RequestPUT();
                break;
            case "delete":
                request = new RequestDELETE();
                break;
            default:
                request = new RequestGET();
                break;
        }
        return request;
    }

}