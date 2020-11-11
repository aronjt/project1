package org.progmatic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Szemantika {

    private final ArrayList<String> text;

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
