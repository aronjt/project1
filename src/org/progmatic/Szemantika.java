package org.progmatic;

import java.io.FileNotFoundException;
import java.util.*;

public class Szemantika {

    private final ArrayList<String> text;

    public Szemantika(ArrayList<String> text) {
        this.text = text;
    }

    public HashMap<String, Integer> wordsNum() {
        ArrayList<String> lowerCaseText = new ArrayList<>();
        for (String s : text) {
            lowerCaseText.add(s.toLowerCase());
        }
        HashMap<String, Integer> wordsNum = new HashMap<>();
        Iterator<String> s = lowerCaseText.iterator();
        while (s.hasNext()) {
            String word = s.next();
            int sum = 0;
            Iterator<String> s1 = lowerCaseText.iterator();
            while (s1.hasNext()) {
                String word1 = s1.next();
                if (word.equals(word1)) {
                    sum++;
                    lowerCaseText.remove(s1);
                }
            }
            wordsNum.putIfAbsent(word, sum);
            lowerCaseText.remove(s);
        }
        return wordsNum;
    }

    public ArrayList<String > top10(HashMap<String, Integer> wordsNum) {
        int max = 0;
        String maxkey = null;
        ArrayList<String> tops = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsNum.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxkey = entry.getKey();
            }
        }
        tops.add(maxkey);
        for (int j = max-1; j > 0 ; j--) {
            for (Map.Entry<String, Integer> entry : wordsNum.entrySet()) {
                if(entry.getValue() == j) {
                    tops.add(entry.getKey());
                }
            }
        }
        ArrayList<String> top10 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            top10.add(tops.get(i));
        }
        return top10;
    }

    @Override
    public String toString() {
        return "Szemantika{" +
                "text=" + text +
                '}';
    }
}
