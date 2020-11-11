package org.progmatic;

import java.util.ArrayList;
import java.util.Map;

public class Bullshit {
    private final ArrayList<String> text;

    public Bullshit(ArrayList<String> text) {
        this.text = text;
    }
    public void generateBullShitRandomOrderFromText(ArrayList<String>text, int textLength){
        StringBuilder bullShit=new StringBuilder();

        for (int i = 0; i < textLength; i++) {
            int random=(int)(Math.random()*text.size());
            bullShit.append(' ');
            bullShit.append(text.get(random));


        }
        System.out.println(bullShit.toString());

    }
public void generateBullShitWithTopWords(Map<String,Integer>map, int textLenght){

}
public void generateBullShitWithTopTwoWordPairs(Map<String,Integer>map, int textLenght){

}
}
