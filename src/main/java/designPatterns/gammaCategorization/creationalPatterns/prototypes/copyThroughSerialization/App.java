package designPatterns.gammaCategorization.creationalPatterns.prototypes.copyThroughSerialization;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class App {
    public static void main(String[] args) {
        Foo foo = new Foo("asd","123");
        Foo foo2 = SerializationUtils.roundtrip(foo);
        foo2.stuff = "xyz";
        System.out.println(foo);
        System.out.println(foo2);
    }
}

class Foo implements Serializable {
    String stuff, whatever;

    public Foo(String stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff='" + stuff + '\'' +
                ", whatever='" + whatever + '\'' +
                '}';
    }

}
