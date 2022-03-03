package factoryRequestToken;

public class RequestInformationToken {
    private String url;
    private String body;

    public RequestInformationToken(){}

    public String getUrl() {
        return url;
    }

    public RequestInformationToken setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getBody() {
        return body;
    }

    public RequestInformationToken setBody(String body) {
        this.body = body;
        return this;
    }
}