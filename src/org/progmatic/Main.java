package org.progmatic;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Reader read = new Reader();
        Szemantika szem = new Szemantika(read.read("files/ember.txt"));
        System.out.println(szem);
        System.out.println("Top 10");
        System.out.println(szem.top10(szem.wordsNum()));
        System.out.println("Top 10 szarok nélkül");
        System.out.println(szem.top10WithOutCommon(szem.wordsNum()));
        System.out.println("Top 10 név");
        System.out.println(szem.top10Name(szem.bigCapital()));
        System.out.println("Bullshit");
        Bullshit bullshit = new Bullshit(read.read("files/proba.txt"));
        bullshit.generateBullShitRandomOrderFromText(10);
        bullshit.generateBullShitWithTopWords(10); //Ebben benne van a top10 szavunk is
    }
}
