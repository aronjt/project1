package org.progmatic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Szemantika {

    private ArrayList<String> text = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {


    }

    public Szemantika(ArrayList<String> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Szemantika{" +
                "text=" + text +
                '}';
    }
}
