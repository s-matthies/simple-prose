package de.htw_berlin.prose;

import de.htw_berlin.fb4.ossd.prose.ProseBuilder;

public class CollaborativeProse {

    private final ProseBuilder builder;

    public CollaborativeProse() {
        this.builder = new ProseBuilder();
        SimpleWeatherSentence berlinWeather = new SimpleWeatherSentence();
        SimpleWeatherSentence bangkokWeather = new SimpleWeatherSentence("Bangkok");
        SimpleWeatherSentence pragWeather = new SimpleWeatherSentence("Prag");
        de.htw_berlin.fb4.examples.SimpleSentence peerSentence1 = new de.htw_berlin.fb4.examples.SimpleSentence();
        de.htw_berlin.fb4.elise.SimpleSentence peerSentence2 = new de.htw_berlin.fb4.elise.SimpleSentence();

        builder.register(berlinWeather);
        builder.register(bangkokWeather);
        builder.register(pragWeather);
        builder.register(peerSentence1);
        builder.register(peerSentence2);
    }

    public void printProse() {
        System.out.println(builder.get());
    }

}
