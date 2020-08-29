package designPatterns.gammaCategorization.creationalPatterns.prototypes;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(new String[]{"Fabio","Apolonio"}
        ,new Address("paulo gorski", 610));

        Person person1 = (Person) person.clone();
        person1.names[0] = "Bel";
        person1.address.houseNumber=456;

        System.out.println(person);
        System.out.println(person1);

    }
}

class Address implements Cloneable {
    String streetName;
    int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName,houseNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}

class Person implements Cloneable {
    String[] names;
    Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // wrong implementation
        // return new Person(names,  address);
        return new Person(names.clone(),(Address) address.clone());
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }
}