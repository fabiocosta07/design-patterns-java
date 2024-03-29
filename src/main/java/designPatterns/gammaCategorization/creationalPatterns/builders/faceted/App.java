package designPatterns.gammaCategorization.creationalPatterns.builders.faceted;

public class App {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb
                .lives()
                  .at("123 london road")
                  .in("London")
                  .withPostCode("SW123DC")
                .works()
                  .at("Fabrikam")
                  .asA("engineer")
                  .earning(1230000)
                .build();
        System.out.println(person);
    }

}
class Person {
    //address
    public  String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annulIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annulIncome=" + annulIncome +
                '}';
    }
}
// builder facade
class PersonBuilder {
    protected Person person = new Person();

    public PersonAddressBuilder lives(){
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works(){
        return new PersonJobBuilder(person);
    }

    public Person build(){
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder {
    public PersonAddressBuilder(Person person) {
        this.person = person;
    }
    public PersonAddressBuilder at(String streetAddress){
        person.streetAddress = streetAddress;
        return this;
    }
    public PersonAddressBuilder withPostCode(String postcode){
        person.postcode = postcode;
        return this;
    }
    public PersonAddressBuilder in(String city){
        person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonBuilder {
    public PersonJobBuilder(Person person) {
        this.person = person;
    }
    public PersonJobBuilder at(String companyName){
        person.companyName = companyName;
        return this;
    }
    public PersonJobBuilder asA(String position){
        person.position = position;
        return this;
    }
    public PersonJobBuilder earning(int annualIncome){
        person.annulIncome = annualIncome;
        return this;
    }
}