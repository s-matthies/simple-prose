package de.htw_berlin.prose;

import de.htw_berlin.fb4.ossd.prose.ProseBuilder;

public class CollaborativeProse {

    private ProseBuilder builder;
    private final SimpleWeatherSentence berlinWeather;
    private SimpleWeatherSentence bangkokWeather;
    private SimpleWeatherSentence pragWeather;
    private final de.htw_berlin.fb4.examples.SimpleSentence peerSentence1;
    private final de.htw_berlin.fb4.elise.SimpleSentence peerSentence2;


    public CollaborativeProse() {
        this.builder = new ProseBuilder();
        this.berlinWeather = new SimpleWeatherSentence();
        this.bangkokWeather = new SimpleWeatherSentence("Bangkok");
        this.pragWeather = new SimpleWeatherSentence("Prag");
        this.peerSentence1 = new de.htw_berlin.fb4.examples.SimpleSentence();
        this.peerSentence2 = new de.htw_berlin.fb4.elise.SimpleSentence();

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
