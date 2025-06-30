/*
 * Copyright (C) 2025 Sabine Matthies
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *
 * SPDX-License-Identifier: GPL-3.0
 */

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

            // Prüfe den HTTP-Statuscode und gib spezifische Fehlermeldungen aus
            switch (response.statusCode()) {
                case 200:
                    // Erfolgreiche Antwort - weiter mit der Verarbeitung
                    break;
                case 401:
                    return String.format("Ungültiger oder fehlender API-Key (HTTP 401)");
                case 403:
                    return String.format("Zugriff verweigert - möglicherweise ungültiger API-Key oder fehlende Berechtigung (HTTP 403)");
                case 404:
                    return String.format("Ressource nicht gefunden - Stadt '%s' existiert möglicherweise nicht oder API-Endpoint ist ungültig (HTTP 404)", city);
                case 429:
                    return String.format("API-Rate-Limit überschritten - zu viele Anfragen (HTTP 429)");
                case 500:
                    return String.format("Server-Fehler beim Wetterdienst (HTTP 500)");
                default:
                    return String.format("Wetterdaten für %s konnten nicht abgerufen werden (HTTP %d)", city, response.statusCode());
            }

            JSONObject jsonResponse = new JSONObject(response.body());
            double temperature = jsonResponse.getJSONObject("main").getDouble("temp");

            return String.format("In %s sind es aktuell %.1f °C.", city, temperature);

        } catch (Exception e) {
            return "Error while retrieving weather data: " + e.getMessage();
        }
    }
}
