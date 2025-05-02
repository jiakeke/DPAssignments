package facade.api;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        JsonParser jsonParser = new JsonParser();
        APIFacade apiFacade = new APIFacade(request, response, jsonParser);

        String urlString = "https://api.chucknorris.io/jokes/random";
        String attribute = "value";

        String joke = apiFacade.getAttributeValueFromJson(urlString, attribute);
        System.out.println("Chuck Norris Joke: " + joke);

        String base = apiFacade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "base");
        System.out.println("Currency: " + base);


    }
}
