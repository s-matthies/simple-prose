package de.htw_berlin.prose;
import java.util.Arrays;
import java.util.List;

import de.htw_berlin.fb4.ossd.prose.Sentence;

public class SimpleSentence implements Sentence {
    private final String text;

    public SimpleSentence(String text) {
        this.text = text;
    }

    @Override
    public String get() {
        return text;
    }

    // Returns a list of words in the sentence, split by whitespace
    public List <String> getWords() {
        return Arrays.asList(text.split("\\s+"));
    }
}
