package org.progmatic;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Reader read = new Reader();
        Bullshit bullshit= new Bullshit(read.read("files/proba.txt"));
        Szemantika szem = new Szemantika(read.read("files/proba.txt"));
        System.out.println(szem);
        System.out.println("BullShit: ");
        bullshit.generateBullShitRandomOrderFromText(read.read("files/proba.txt"),10);
    }
}
