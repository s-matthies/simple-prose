package de.htw_berlin.prose;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

import de.htw_berlin.fb4.ossd.prose.Sentence;

public class SimpleWeatherSentence implements Sentence {
    private final String city;

    public SimpleWeatherSentence(String city) {
        this.city = city;
    }

    public SimpleWeatherSentence() {
        this("Berlin");
    }

    @Override
    public String get() {
        try {
            String apiKey = System.getenv("OPENWEATHER_API_KEY");
            if (apiKey == null || apiKey.isEmpty()) {
                return "API-Key fehlt!";
            }

            String url = String.format(
                    "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                    city, apiKey);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonResponse = new JSONObject(response.body());
            double temperature = jsonResponse.getJSONObject("main").getDouble("temp");

            return String.format("In %s sind es aktuell %.1f °C.", city, temperature);

        } catch (Exception e) {
            return "Fehler beim Abrufen der Wetterdaten: " + e.getMessage();
        }
    }
}
