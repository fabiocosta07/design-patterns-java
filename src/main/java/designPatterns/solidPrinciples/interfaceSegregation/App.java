package designPatterns.solidPrinciples.interfaceSegregation;

// Interface Segregation Principal
// You should try to split interfaces into smaller interfaces

public class App {
    public static void main(String [] args){

    }

}

class Document {
}

interface Machine {
    public void print(Document d);
    public void fax(Document d);
    public void scan(Document d);
}

class MultiFunctionPrinter implements Machine {

    @Override
    public void print(Document d) {
    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class OlFashionPrinter implements Machine {
    @Override
    public void print(Document d) {
    }

    @Override
    public void fax(Document d)  {
        // throw new Exception();
        // wrong implementation
        // need to change interface declaration
        // which you might not have access
    }

    @Override
    public void scan(Document d) {
        // throw new Exception();
        // wrong implementation
        // need to change interface declaration
        // which you might not have access
    }
}

// solution

interface Printer {
    public void printer(Document d);
}

interface Scanner {
    public void scan(Document d);
}

// YAGNI - you ain't gonna need it

class JustPrinter implements Printer {
    @Override
    public void printer(Document d) {
    }
}

class PhotoCopier implements Printer, Scanner {
    @Override
    public void printer(Document d) {
    }

    @Override
    public void scan(Document d) {
    }
}

interface MultiFunctionDevice extends Printer, Scanner {
}

// simple decorator example
class MultiFunctionMachine implements MultiFunctionDevice {

    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void printer(Document d) {
        printer.printer(d);
    }
    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}