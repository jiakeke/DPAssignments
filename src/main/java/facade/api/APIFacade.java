package facade.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;

public class APIFacade {
    private Request request;
    private Response response;
    private JsonParser jsonParser;

    public APIFacade(Request request, Response response, JsonParser jsonParser) {
        this.request = request;
        this.response = response;
        this.jsonParser = jsonParser;
    }

    public String getAttributeValueFromJson(String urlString, String attribute) {
        try {
            HttpURLConnection connection = request.open(urlString);
            String jsonString = response.read(connection);
            JSONObject jsonObject = jsonParser.parse(jsonString);
            String value = (String) jsonObject.get(attribute);
            if (value == null) {
                throw new IllegalArgumentException("Attribute " + attribute + " not found in JSON response.");
            }
            return value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
