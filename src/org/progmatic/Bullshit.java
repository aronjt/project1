package org.progmatic;

import java.util.ArrayList;
import java.util.Map;

public class Bullshit {
    private final ArrayList<String> text;

    public Bullshit(ArrayList<String> text) {
        this.text = text;
    }

    public void generateBullShitRandomOrderFromText(int textLength) {
        StringBuilder bullShit = new StringBuilder();

        for (int i = 0; i < textLength; i++) {
            int random = (int) (Math.random() * text.size());
            bullShit.append(' ');
            bullShit.append(text.get(random));


        }
        System.out.println(bullShit.toString());

    }

    public void generateBullShitWithTopWords(int textLenght) {
        Szemantika szemantika = new Szemantika(text);
        szemantika.top10(szemantika.wordsNum());
        StringBuilder bullShit = new StringBuilder();
        for (int i = 0; i < textLenght; i++) {
            if ((int) (Math.random() * 2) + 1 == 1) {
                int random = (int) (Math.random() * text.size());
                bullShit.append(' ');
                bullShit.append(text.get(random));
            } else {
                bullShit.append(' ');
                bullShit.append(szemantika.top10(szemantika.wordsNum()).get((int) (Math.random() * 10)));
            }


        }
        System.out.println(bullShit.toString());
    }
}
