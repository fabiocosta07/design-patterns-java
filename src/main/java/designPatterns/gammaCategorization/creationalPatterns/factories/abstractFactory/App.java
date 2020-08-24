package designPatterns.gammaCategorization.creationalPatterns.factories.abstractFactory;

import org.javatuples.Pair;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        HotDrinkMachine hotDrinkMachine = new HotDrinkMachine();
        hotDrinkMachine.makeHotDrink();
    }
}

interface HotDrink {
    public void consume();
}

class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("this is a delicious tea");
    }
}

class Coffee implements HotDrink {
    @Override
    public void consume() {
        System.out.println("this is a delicious coffee");
    }
}

interface HotDrinkFactory {
    public HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Preparing " + amount + " ml of Tea");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory {

    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Preparing " + amount + " ml of Coffee");
        return new Coffee();
    }
}

class HotDrinkMachine {
    private List<Pair<String, HotDrinkFactory>> namedFactories
            = new ArrayList<>();

    public HotDrinkMachine() throws Exception {
        Set<Class<? extends HotDrinkFactory>> types
                = new Reflections("").getSubTypesOf(HotDrinkFactory.class);

        for (Class<? extends  HotDrinkFactory> type : types) {
            namedFactories.add(new Pair<>(
                    type.getSimpleName().replace("Factory" ,""),
                    type.getDeclaredConstructor().newInstance())
            );
        }
    }

    public HotDrink makeHotDrink() throws  Exception {
        System.out.println("Available drinks");
        for (int index = 0; index < namedFactories.size(); ++index){
            Pair<String, HotDrinkFactory> hotDrinkPair = namedFactories.get(index);
            System.out.println(""+index+ " " +hotDrinkPair.getValue(0));
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s;
            int i, amount;
            if ((s = reader.readLine()) != null
                   && (i = Integer.parseInt(s)) >= 0
                   && i < namedFactories.size()) {
                System.out.println("Specify amount:");
                s = reader.readLine();
                if(s != null && (amount = Integer.parseInt(s)) > 0){
                    return namedFactories.get(i).getValue1().prepare(amount);
                }
            }
        }

    }
}

