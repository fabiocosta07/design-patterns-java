package designPatterns.solidPrinciples.singleResponsability;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String [] args){

    }
}

class Journal {
    private final List<String> entries = new ArrayList<>();
    public static int count = 0;

    public void addEntry(String text){
        entries.add(++count + ":" + text);
    }
    public void removeEntry(int i){
        entries.remove(i);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

