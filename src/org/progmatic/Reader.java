package org.progmatic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Reader {

    private static ArrayList<String> text = new ArrayList<>();

    public Reader() {
    }

    public static ArrayList<String> read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("files/proba.txt"));
        while (sc.hasNext()) {
            String word = sc.next();
            char[] wordArray = word.toCharArray();
            if (!Character.isLetter(wordArray[wordArray.length-1])) {
                StringBuilder newWord = new StringBuilder();
                for (int i = 0; i < wordArray.length - 1; i++) {
                    newWord.append(wordArray[i]);
                }
            }else {
                    text.add(word);
            }
        }

        return text;
    }
}
