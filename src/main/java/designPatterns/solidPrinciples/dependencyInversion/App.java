package designPatterns.solidPrinciples.dependencyInversion;


import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String [] args){
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}
enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;

    public Person(String name){
        this.name = name;
    }
}
// Low level module
class Relationships implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

/*
    //wrong implementation
    // not needed anymore
    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }
*/
    public void addParentAndChild(Person parent, Person child){
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> x.getValue0().name.equals("John")
                        && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }

}
// High level module
class Research {
/*
    //wrong implementation
    public Research(Relationships relationships) {
        List<Triplet<Person,Relationship,Person>> relations = relationships.getRelations();
        relations.stream()
                .filter(x -> x.getValue0().name.equals("John")
                && x.getValue1() == Relationship.PARENT)
                .forEach(ch -> System.out.println(
                        "john has a child called " + ch.getValue2().name
                ));
    }*/

    public Research(RelationshipBrowser relationshipBrowser) {
        relationshipBrowser.findAllChildrenOf("John")
                .forEach(ch -> System.out.println(
                        "John has a child called " + ch.name));
    }
}

// Solution
// you should depend of abstraction

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}
