package de.htw_berlin.prose;

import de.htw_berlin.fb4.ossd.prose.Prose;
import de.htw_berlin.fb4.ossd.prose.ProseBuilder;

import java.util.List;

public class App {
    public static void main(String[] args) {

        // === Teil 1: Eigene Klassen verwenden ===
        SimpleSentence s1 = new SimpleSentence("Hello world!");
        SimpleSentence s2 = new SimpleSentence("GitHub Packages are cool.");

        System.out.println("Wörter in Satz 1: " + s1.getWords());
        System.out.println("Wörter in Satz 2: " + s2.getWords());

        SimpleProse simpleProse = new SimpleProse(List.of(s1, s2));

        System.out.println("=== Ausgabe mit SimpleProse ===");
        System.out.println(simpleProse.getText());
        System.out.println();

        // === Teil 2: ProseBuilder verwenden ===
        ProseBuilder builder = new ProseBuilder();
        builder.register(s1);
        builder.register(s2);

        // Ausgabe mit builder.get()
        System.out.println("=== Ausgabe mit ProseBuilder ===");
        System.out.println(builder.get());
    }
}