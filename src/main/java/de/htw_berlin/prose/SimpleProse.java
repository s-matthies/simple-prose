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
        return getText();
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        sentences.forEach(sentence -> sb.append(sentence.get()).append("\n"));
        return sb.toString().trim();
    }
}
