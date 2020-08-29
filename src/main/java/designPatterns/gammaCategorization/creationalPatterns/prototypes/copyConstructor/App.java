package designPatterns.gammaCategorization.creationalPatterns.prototypes.copyConstructor;

public class App {
    public static void main(String[] args) {
        Employee employee = new Employee("Ze"
                ,new Address("av paulista","sao paulo"));
        Employee employee1 = new Employee(employee);
        employee1.name="Joao";

        System.out.println(employee);
        System.out.println(employee1);
    }
}

class Address {
    String streetName, city;

    public Address(String streetName, String city) {
        this.streetName = streetName;
        this.city = city;
    }

    public Address(Address other){
        this.streetName = other.streetName;
        this.city = other.city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Employee {
    String name;
    Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee other){
        this.name = other.name;
        this.address = new Address(other.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}