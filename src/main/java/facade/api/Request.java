package facade.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    public HttpURLConnection open(String urlString) throws IOException {
        try {
            if (urlString == null || urlString.isEmpty()) {
                throw new IllegalArgumentException("URL cannot be null or empty");
            }
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            return connection;
        } catch (IllegalArgumentException e) {
            throw new IOException("Invalid URL: " + e.getMessage(), e);
        }
    }
}
