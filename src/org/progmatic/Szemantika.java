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

    public LinkedList<String > top10(HashMap<String, Integer> wordsNum) {
        LinkedList<String> tops = new LinkedList<>();
        tops.add(maxOfArray(wordsNum)[0]);
        int max = Integer.parseInt(maxOfArray(wordsNum)[1]);
        for (int i = 0; i < 9; i++) {
            tops.add(maxOfArrayGreaterThan(wordsNum, max)[0]);
            max = Integer.parseInt(maxOfArrayGreaterThan(wordsNum, max)[1]);
        }
        return tops;
    }

    public LinkedList<String> top10WithOutCommon(HashMap<String, Integer> wordsNum) {
        LinkedList<String> tops = new LinkedList<>();
        String[] conjunctionArr = {"a", "az", "aki", "amit", "amely", "így", "ez", "sem", "van", "volt", "ott", "itt", "ezt", "azt", "volt", "ezek", "amikor", "ahogy", "most", "akkor", "ekkor", "hogy", "s", "és", "egy", "pedig", "azt", "azért", "ha", "még", "vagy", "de", "e", "nem", "mint", "is", "csak", "mely", "meg", "mit", "el", "hát", "ki", "már", "mert", "hol", "mért", "én", "te", "ő", "mi", "ti", "ők", "hogyha", "mind", "minden", "miért", "lesz", "más"};
        ArrayList<String> conjunction = new ArrayList<>(Arrays.asList(conjunctionArr));
        int max = Integer.parseInt(maxOfArray(wordsNum)[1]);
        while (tops.size() != 10) {
            if (conjunction.contains(maxOfArrayGreaterThan(wordsNum, max)[0])) {
                max = Integer.parseInt(maxOfArrayGreaterThan(wordsNum, max)[1]);
            } else {
                tops.add(maxOfArrayGreaterThan(wordsNum, max)[0]);
                max = Integer.parseInt(maxOfArrayGreaterThan(wordsNum, max)[1]);
            }
        }
        return tops;
    }

    public HashMap<String, Integer> bigCapital() {
        ArrayList<String> firstCapital = new ArrayList<>();
        for (String s : text) {
            char[] wordArr = s.toCharArray();
            if (Character.isUpperCase(wordArr[0])) {
                firstCapital.add(s);
            }
        }
        HashMap<String, Integer> wordsNum = new HashMap<>();
        Iterator<String> s = firstCapital.iterator();
        while (s.hasNext()) {
            String word = s.next();
            int sum = 0;
            Iterator<String> s1 = firstCapital.iterator();
            while (s1.hasNext()) {
                String word1 = s1.next();
                if (word.equals(word1)) {
                    sum++;
                    firstCapital.remove(s1);
                }
            }
            wordsNum.putIfAbsent(word, sum);
            firstCapital.remove(s);
        }
        return wordsNum;
    }

    public LinkedList<String> top10Name(HashMap<String, Integer> bigCapital) {
        LinkedList<String> topNames = new LinkedList<>();
        String[] conjunctionArr = {"A", "Az", "Nagyon", "Pár", "Ez", "Ahogy", "Amikor", "Ennek", "Annak", "Ezek", "Azok", "Hogy", "S", "És", "Egy", "Pedig", "Azt", "Azért", "Ha", "Még", "Vagy", "De", "E", "Nem", "Mint", "Is", "Csak", "Mely", "Meg", "Mit", "Én-je", "El", "Hát", "Ki", "Már", "Mert", "Hol", "Mért", "Én", "Te", "Ő", "Mi", "Ti", "Ők", "Hogyha", "Mind", "Minden", "Miért", "Lesz", "Más", "Ne", "AZ", "IE", "AE"};
        ArrayList<String> conjunction = new ArrayList<>(Arrays.asList(conjunctionArr));
        int max = Integer.parseInt(maxOfArray(bigCapital)[1]);
        while (topNames.size() != 10) {
            if (conjunction.contains(maxOfArrayGreaterThan(bigCapital, max)[0])) {
                max = Integer.parseInt(maxOfArrayGreaterThan(bigCapital, max)[1]);
            } else {
                topNames.add(maxOfArrayGreaterThan(bigCapital, max)[0]);
                max = Integer.parseInt(maxOfArrayGreaterThan(bigCapital, max)[1]);
            }
        }
        return topNames;
    }

    @Override
    public String toString() {
        return "Szemantika{" +
                "text=" + text +
                '}';
    }
}
