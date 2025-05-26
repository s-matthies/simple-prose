package de.htw_berlin.prose;

import de.htw_berlin.fb4.ossd.prose.ProseBuilder;

import java.util.List;

public class App {
    public static void main(String[] args) {

        SimpleWeatherSentence berlinWeather = new SimpleWeatherSentence();  // Berlin ist Standard
        SimpleWeatherSentence bangkokWeather = new SimpleWeatherSentence("Bangkok");
        SimpleWeatherSentence pragWeather = new SimpleWeatherSentence("Prag");

        // with SimpleProse
        SimpleProse simpleProse = new SimpleProse(List.of(berlinWeather, bangkokWeather, pragWeather
        ));

        System.out.println("=== Output with SimpleProse ===");
        System.out.println(simpleProse.getText());
        System.out.println();

        // with ProseBuilder
        ProseBuilder builder = new ProseBuilder();
        builder.register(berlinWeather);
        builder.register(bangkokWeather);
        builder.register(pragWeather);

        System.out.println("=== Output with ProseBuilder ===");
        System.out.println(builder.get());
    }
}