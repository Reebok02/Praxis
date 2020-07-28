package practicesb.day2;


import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MainTask4 {
    public static void main(String[] args) {
        Circle circle = new Circle(0, 0, 10);
        circle.print();
        circle.move();
        circle.print();

    }
}


abstract class Figure {
    abstract void print();

    abstract void move();

    abstract void scale(double ratio);

    abstract double square();

    public double getRandomNumber(double min, double max) {
        return (double) Math.ceil(((Math.random() * (max - min)) + min));
    }

}


class Circle extends Figure {
    private static final double PI = 3.14;
    private double radius;
    private double x, y;

    Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите координату x: ");
        this.x = in.nextDouble();
        System.out.print("Введите координату y: ");
        this.y = in.nextDouble();
        System.out.print("Введите радиус: ");
        this.radius = in.nextDouble();
    }

    public double getRadius() {
        return radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    @Override
    void print() {
        System.out.println("Это круг с радиусом " + this.getRadius() + " и координатами (" + this.getX() + ";" + this.getY() + ") в центре");
    }

    @Override
    void move() {
        Circle circle = new Circle();
        this.x = circle.getX();
        this.y = circle.getY();

    }

    @Override
    void scale(double ratio) {
        this.radius = this.radius * ratio;
    }

    @Override
    double square() {
        return PI * Math.pow(radius, 2);
    }

    //проверка что точка находится в кругу
    boolean isCenter(double x, double y) {
        if (Math.abs(this.getX()) < Math.abs(x) || Math.abs(this.getY()) < Math.abs(y)) {
            return false;
        } else {
            return true;
        }
    }

    //проверка что другой круг находится в кругу
    boolean isCircle(Circle circle) {
        if (circle.getRadius() > this.getRadius()) {
            return false;
        } else {
            return true;
        }
    }

    //длина окружности
    double circumference() {
        return 2 * PI * this.radius;
    }

    //перемещает круг в случайную точку
    void moveInDot() {
        Random random = new Random();
        double x1 = getRandomNumber(-99, 100);
        double y1 = getRandomNumber(-99, 100);
        this.x = x1;
        this.y = y1;
    }

    //расстояние между двумя точками
    double distanceBetweenTwoDots(Circle circle) {
        double result = Math.abs(Math.sqrt(Math.pow(circle.getX() - this.x, 2) + Math.pow(circle.getY() - this.y, 2)));
        return result;
    }

    //касаются ли окружности в одной точке
    boolean isTouchWithDifferentCircle(Circle circle) {
        if ((Math.ceil(this.distanceBetweenTwoDots(circle)) == this.radius + circle.getRadius()) || (Math.ceil(this.distanceBetweenTwoDots(circle)) == Math.abs(this.radius - circle.getRadius()))) {
            return true;
        } else {
            return false;
        }
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите координату х");
        this.x = input.nextDouble();
        System.out.println("Введите координату y");
        this.y = input.nextDouble();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    void print() {
        System.out.println("Это точка с координатами (" + this.getX() + ";" + this.getY() + ")");
    }

    void move(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //определение координатной четверти
    int defirminingCoordinateQuarter() {
        if (this.x > 0 && this.y > 0) {
            return 1;
        } else if (this.x > 0 && this.y < 0) {
            return 4;
        } else if (this.x < 0 && this.y > 0) {
            return 2;
        } else {
            return 3;
        }
    }

    //определение симметрии точек
    boolean isSymmetrical(Point point) {
        if (Math.abs(this.x) == Math.abs(point.x) && (Math.abs(this.y) == Math.abs(point.y))) {
            return true;
        } else {
            return false;
        }
    }

    boolean isCollinear(Point point1, Point point2) {
        return ((point2.x - this.x) / (point1.x - this.x) == (point2.y - this.y) / (point1.y - this.y));
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj;
        if ((this.x == point.getX()) && (this.y == point.getY())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Triangle extends Figure {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Triangle(){
        point1 = new Point();
        point2 = new Point();
        point3 = new Point();
    }

    @Override
    void print() {
        System.out.println("Это треугольник с координатами (" + this.point1.getX() + ";" +this.point1.getY() +"), " + "(" + this.point2.getX() + ";" +this.point2.getY() +"), " + "(" + this.point3.getX() + ";" +this.point3.getY() +")");
    }

    @Override
    void move() {
        this.point1 = new Point();
        this.point2 = new Point();
        this.point3 = new Point();
    }

    @Override
    void scale(double ratio) {
        point1.setX(point1.getX() * ratio);
        point1.setY(point1.getY() * ratio);
        point2.setX(point2.getX() * ratio);
        point2.setY(point2.getY() * ratio);
        point3.setX(point3.getX() * ratio);
        point3.setY(point3.getY() * ratio);
    }

    @Override
    double square() {
        double half = perimetr() / 2;
        double ab = Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2) + Math.pow((point2.getY() - point1.getY()), 2));
        double bc = Math.sqrt(Math.pow((point3.getX() - point2.getX()), 2) + Math.pow((point3.getY() - point2.getY()), 2));
        double ca = Math.sqrt(Math.pow((point3.getX() - point1.getX()), 2) + Math.pow((point3.getY() - point1.getY()), 2));
        double square = Math.sqrt(half * (half - ab) * (half - bc) * (half - ca));
        return square;

    }

    double perimetr(){
        double ab = Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2) + Math.pow((point2.getY() - point1.getY()), 2));
        double bc = Math.sqrt(Math.pow((point3.getX() - point2.getX()), 2) + Math.pow((point3.getY() - point2.getY()), 2));
        double ca = Math.sqrt(Math.pow((point3.getX() - point1.getX()), 2) + Math.pow((point3.getY() - point1.getY()), 2));
        return ab + bc + ca;
    }
}
