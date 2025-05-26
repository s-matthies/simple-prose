package de.htw_berlin.prose;

import de.htw_berlin.fb4.ossd.prose.Prose;
import de.htw_berlin.fb4.ossd.prose.Sentence;

import java.util.List;

public class SimpleProse implements Prose {
    private final List<Sentence> sentences;

    public SimpleProse(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String get() {
        return getText(); // ruft unsere eigene Methode auf
    }

    // Returns the text of the prose by concatenating the text of each sentence
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.get()).append(" ");
        }
        return sb.toString().trim();
    }
}
