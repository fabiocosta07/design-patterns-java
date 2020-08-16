package designPatterns.solidPrinciples.liskovSubstitution;

//LSP - Liskov Substitution Principal
// You should be able to substitute a subclass for a base class, or the other way around
// without breaking anything.

public class App {
    public static void main(String [] args){
        Rectangle rectangle = new Rectangle(5,4);
        Demo.userId(rectangle);
        Rectangle square = new Square(5);
        Demo.userId(square);
    }
}
class Rectangle {
    protected int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

class Square extends Rectangle {
    public Square(int size) {
        super(size,size);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

class Demo {
    static void userId(Rectangle r){
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + (width * 10) +
                ", got Area "+ r.getArea());
    }
}

// possible solution 1

class RectangleSolution extends Rectangle{
    public RectangleSolution(int width, int height) {
        super(width, height);
    }
    public boolean isSquare(){
        return width == height;
    }
}

// possible solution 2

class RectangleFactory {
    public Rectangle newRectangle(int width, int length){
        return new Rectangle(width,length);
    }
    public Rectangle newSquare(int size){
        return new Rectangle(size,size);
    }
}
