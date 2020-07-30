package practicesb.day2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Circle extends Figure {
    private double radius;
    private double x, y;

    public Circle(double x, double y, double radius) {
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
    public void print() {
        System.out.println("Это круг с радиусом " + this.getRadius() + " и координатами (" + this.getX() + ";" + this.getY() + ") в центре");
    }

    //перемещает круг в случайную точку
    @Override
    public void move() {
        double x1 = ThreadLocalRandom.current().nextDouble(-99, 100);
        double y1 = ThreadLocalRandom.current().nextDouble(-99, 100);
        this.x = x1;
        this.y = y1;
    }

    @Override
    public void scale(double ratio) {
        this.radius = this.radius * ratio;
    }

    @Override
    public double square() {
        return Math.PI * Math.pow(radius, 2);
    }

    //проверка что точка находится в кругу
    public boolean isContainPoint(double x, double y) {
        return ((Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) <= Math.pow(this.radius, 2));

    }

    //проверка что другой круг находится в кругу
    public boolean isCircle(Circle circle) {
        if (this.isContainPoint(circle.getX(), circle.getY())) {
            return  this.distanceBetweenTwoDots(circle) < (this.getRadius() - circle.radius);
        }
        return false;
    }

    //длина окружности
    public double circumference() {
        return 2 * Math.PI * this.radius;
    }

    //расстояние между двумя точками
    public double distanceBetweenTwoDots(Circle circle) {
        return Math.abs(Math.sqrt(Math.pow(circle.getX() - this.x, 2) + Math.pow(circle.getY() - this.y, 2)));
    }

    //касаются ли окружности в одной точке
    public boolean isTouchWithDifferentCircle(Circle circle) {
        return ((Math.ceil(this.distanceBetweenTwoDots(circle)) == this.radius + circle.getRadius()) || (Math.ceil(this.distanceBetweenTwoDots(circle)) == Math.abs(this.radius - circle.getRadius())));
    }
}