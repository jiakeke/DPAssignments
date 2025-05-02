package facade.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
    public JSONObject parse(String jsonString) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jsonString);
    }
}
