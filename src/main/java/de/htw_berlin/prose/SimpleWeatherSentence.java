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

            JSONObject jsonResponse = new JSONObject(response.body());
            double temperature = jsonResponse.getJSONObject("main").getDouble("temp");

            return String.format("In %s sind es aktuell %.1f °C.", city, temperature);

        } catch (Exception e) {
            return "Error while retrieving weather data: " + e.getMessage();
        }
    }
}
