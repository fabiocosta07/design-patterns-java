package designPatterns.gammaCategorization.creationalPatterns.factories.factory;

public class App {
    public static void main(String[] args) {
        Point point = Point.PointFactory.newPolarPoint(5, 7);
        System.out.println(point);
    }
}

enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

class Point {
    private double x, y;

/*
    //wrong contructor implamentation
    // you will need to explain the the meaning of a/b depending of the coordinateSystem
    public Point(double a, double b, CoordinateSystem cs) {
        switch (cs){
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                this.x = a * Math.cos(b);
                this.y = a * Math.sin(b);
                break;
        }
    }
*/

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public static class PointFactory {
        public static Point newCartesianPoint(double a, double b){
            return new Point(a,b);
        }

        public static Point newPolarPoint(double rho, double theta){
            return new Point(rho * Math.cos(theta),
                    rho * Math.sin(theta));
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

