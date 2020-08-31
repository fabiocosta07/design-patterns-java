package designPatterns.gammaCategorization.creationalPatterns.singleton.basicSingleton;

public class App {
    public static void main(String[] args) {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(222);
        BasicSingleton singleton1 = BasicSingleton.getInstance();
        singleton1.setValue(333);
        System.out.println(singleton.getValue());
    }
}

class BasicSingleton {
    private static BasicSingleton INSTANCE;
    private int value;

    private BasicSingleton() {
    }

    public static BasicSingleton getInstance() {
        if (INSTANCE == null){
            INSTANCE = new BasicSingleton();
        }
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}