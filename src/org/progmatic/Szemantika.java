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

    public String[] maxOfArray(HashMap<String, Integer> wordsNum) {
        String[] maxArr = new String[2];
        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> entry : wordsNum.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        maxArr[0] = maxKey;
        maxArr[1] = Integer.toString(max);
        return maxArr;

    }

    public String[] maxOfArrayGreaterThan(HashMap<String, Integer> wordsNum, int max) {
        String[] greaterMaxArr = new String[2];
        String greaterMaxKey = null;
        int greaterMax = 0;
        for (Map.Entry<String, Integer> entry : wordsNum.entrySet()) {
            if (entry.getValue() > greaterMax && entry.getValue() < max) {
                greaterMax = entry.getValue();
                greaterMaxKey = entry.getKey();
            }
        }
        greaterMaxArr[0] = greaterMaxKey;
        greaterMaxArr[1] = Integer.toString(greaterMax);
        return greaterMaxArr;
    }

    public ArrayList<String > top10(HashMap<String, Integer> wordsNum) {
        ArrayList<String> tops = new ArrayList<>();
        tops.add(maxOfArray(wordsNum)[0]);
        int max = Integer.parseInt(maxOfArray(wordsNum)[1]);
        for (int i = 0; i < 9; i++) {
            tops.add(maxOfArrayGreaterThan(wordsNum, max)[0]);
            max = Integer.parseInt(maxOfArrayGreaterThan(wordsNum, max)[1]);
        }
        return tops;
    }

    @Override
    public String toString() {
        return "Szemantika{" +
                "text=" + text +
                '}';
    }
}
