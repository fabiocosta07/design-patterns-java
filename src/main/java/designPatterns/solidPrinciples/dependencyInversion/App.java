package designPatterns.solidPrinciples.dependencyInversion;


import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String [] args){

    }
}
enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }
}

class Relationships {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child){
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }
}

class Research {
    public Research(Relationships relationships) {
    }
}

