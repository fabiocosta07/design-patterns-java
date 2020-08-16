package designPatterns.solidPrinciples.singleResponsability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// SRP - Single Responsibility Principal
// the class should have a single reason for change

public class App {
    public static void main(String [] args) throws IOException {
        Journal journal = new Journal();
        journal.addEntry("I cried today");
        journal.addEntry("I ate a bug");

        Persistence p = new Persistence();
        String fileName = "/home/dev1/journal.txt";
        p.saveToFile(journal,fileName, true);
        Runtime.getRuntime().exec("gedit "+ fileName);
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

    /* wrong approach
    public void save(String filename) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(filename)){
            out.println(toString());
        }
    }
    public void load(String filename){}
    public void load(URL url){} */
}
class Persistence {
    public void saveToFile(Journal journal,
                           String fileName,
                           boolean overwrite) throws FileNotFoundException{
        if(overwrite || new File(fileName).exists()) {
            try (PrintStream out = new PrintStream(fileName)){
                out.println(journal);
            }
        }
    }
    public Journal load(String filename){
        return null;
    }
    public Journal load(URL url){return null;}
}
