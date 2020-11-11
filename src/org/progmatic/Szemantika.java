package org.progmatic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Szemantika {

    private static ArrayList<String> text = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        text = Reader.read("files/proba.txt");

        System.out.println(text);
    }

}
