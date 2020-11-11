package org.progmatic;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Reader read = new Reader();
        Szemantika szem = new Szemantika(read.read("files/proba.txt"));
        System.out.println(szem);
        System.out.println("Valami");
        Bullshit bullshit=new Bullshit(read.read("files/proba.txt"));
        bullshit.generateBullShitRandomOrderFromText(10);
        
    }
}
