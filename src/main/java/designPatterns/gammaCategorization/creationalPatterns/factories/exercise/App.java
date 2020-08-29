package designPatterns.gammaCategorization.creationalPatterns.factories.exercise;

import java.util.concurrent.atomic.AtomicInteger;

public class App {
}


class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class PersonFactory
{
    private static int id;
    public Person createPerson(String name)
    {
        Person person = new Person(id++,name);
       return  person;
    }
}