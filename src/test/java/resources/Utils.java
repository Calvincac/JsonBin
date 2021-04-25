package resources;

import configuration.ConfigurationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Utils {

    public static RequestSpecification req;
    ConfigurationManager configuration = new ConfigurationManager();

    public RequestSpecification requestSpecification() {
        if(req == null) {
            req = new RequestSpecBuilder()
                    .setBaseUri(configuration.getConfiguration().host())
                    .addHeader("X-Master-Key", configuration.getConfiguration().key())
                    .setContentType(ContentType.JSON)
                    .build();
            return req;
        }
        return req;
    }

    public static String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
