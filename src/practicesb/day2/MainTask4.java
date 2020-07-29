package practicesb.day2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class MainTask4 {
    public static void main(String[] args) {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(5, 11);
        Point point3 = new Point(12, 8);
        Point point4 = new Point(9, 5);
        Point point5 = new Point(5, 6);
        Triangle triangle = new Triangle(point1, point2, point3);

        Polygon polygon = new Polygon(point1, point2, point3, point4, point5);
        polygon.print();
        System.out.println("Центр тяжести многоугольника: " + polygon.getCenterOfGravity().getX() + " " + polygon.getCenterOfGravity().getY());

        polygon.print();
        System.out.println(polygon.square());

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

    //перемещает круг в случайную точку
    @Override
    void move() {
        double x1 = getRandomNumber(-99, 100);
        double y1 = getRandomNumber(-99, 100);
        this.x = x1;
        this.y = y1;
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

    double getDistanceBetweenTwoPoints(Point point) {
        double result = Math.abs(Math.sqrt(Math.pow(point.getX() - this.getX(), 2) + Math.pow(point.getY() - this.getY(), 2)));
        return result;
    }

    boolean isCollinear(Point point1, Point point2) {
        return (0.5 * ((point1.getY() * this.x) + (point1.getX() * point2.getY()) + (point2.getX() * this.y) - ((point1.getX() * this.y) + (point2.getX() * point1.getY()) + (this.x * point2.getY()))) == 0);
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

    public Triangle() {
        while (true) {
            point1 = new Point();
            point2 = new Point();
            point3 = new Point();
            if (point1.isCollinear(point2, point3)) {
                System.out.println("Данный точки лежат на одной прямой, повторите ввод!");
            } else {
                break;
            }
        }
    }

    @Override
    void print() {
        System.out.println("Это треугольник с координатами (" + this.point1.getX() + ";" + this.point1.getY() + "), " + "(" + this.point2.getX() + ";" + this.point2.getY() + "), " + "(" + this.point3.getX() + ";" + this.point3.getY() + ")");
    }

    //перемещение в случайную точку
    @Override
    void move() {
        Point center = this.getCenterOfGravity();
        double x1 = getRandomNumber(-99, 100);
        double y1 = getRandomNumber(-99, 100);
        Point centerBefore = new Point(x1, y1);

        double div1x = this.point1.getX() - center.getX();
        double div1y = this.point1.getY() - center.getY();
        double div2x = this.point2.getX() - center.getX();
        double div2y = this.point2.getY() - center.getY();
        double div3x = this.point3.getX() - center.getX();
        double div3y = this.point3.getY() - center.getY();

        this.point1.setX(centerBefore.getX() + div1x);
        this.point1.setY(centerBefore.getY() + div1y);
        this.point2.setX(centerBefore.getX() + div2x);
        this.point2.setY(centerBefore.getY() + div2y);
        this.point3.setX(centerBefore.getX() + div3x);
        this.point3.setY(centerBefore.getY() + div3y);

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

    double perimetr() {
        double ab = Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2) + Math.pow((point2.getY() - point1.getY()), 2));
        double bc = Math.sqrt(Math.pow((point3.getX() - point2.getX()), 2) + Math.pow((point3.getY() - point2.getY()), 2));
        double ca = Math.sqrt(Math.pow((point3.getX() - point1.getX()), 2) + Math.pow((point3.getY() - point1.getY()), 2));
        return ab + bc + ca;
    }

    Point getCenterOfGravity() {
        double x0 = ((this.point1.getX() + this.point2.getX() + this.point3.getX()) / 3);
        double y0 = ((this.point1.getY() + this.point2.getY() + this.point3.getY()) / 3);
        return new Point(x0, y0);
    }

    Triangle rotate(double degree) {
        double radian = degree * (Math.PI / 180);
        Point center = this.getCenterOfGravity();

        this.point1.setX(this.point1.getX() - center.getX());
        this.point1.setY(this.point1.getY() - center.getY());
        this.point2.setX(this.point2.getX() - center.getX());
        this.point2.setY(this.point2.getY() - center.getY());
        this.point3.setX(this.point3.getX() - center.getX());
        this.point3.setY(this.point3.getY() - center.getY());


       /* double A = this.point1.getDistanceBetweenTwoPoints(center);
        double B = this.point2.getDistanceBetweenTwoPoints(center);
        double C = this.point3.getDistanceBetweenTwoPoints(center);*/

        this.point1.setX(this.point1.getX() * Math.cos(radian) - this.point1.getY() * Math.sin(radian));
        this.point1.setY((this.point1.getX() * Math.sin(radian) + this.point1.getY() * Math.cos(radian)));

        this.point2.setX(this.point2.getX() * Math.cos(radian) - this.point2.getY() * Math.sin(radian));
        this.point2.setY((this.point2.getX() * Math.sin(radian) + this.point2.getY() * Math.cos(radian)));

        this.point3.setX(this.point3.getX() * Math.cos(radian) - this.point3.getY() * Math.sin(radian));
        this.point3.setY((this.point3.getX() * Math.sin(radian) + this.point3.getY() * Math.cos(radian)));


        this.point1.setX(this.point1.getX() + center.getX());
        this.point1.setY(this.point1.getY() + center.getY());
        this.point2.setX(this.point2.getX() + center.getX());
        this.point2.setY(this.point2.getY() + center.getY());
        this.point3.setX(this.point3.getX() + center.getX());
        this.point3.setY(this.point3.getY() + center.getY());


        return this;
    }


}

class Polygon extends Figure {
    private ArrayList<Point> countOfPoints = new ArrayList<>();

    public Polygon(Point... points) {
        for (Point point : points) {
            this.countOfPoints.add(point);
        }
    }

    public Polygon() {
        System.out.println("Введите кол-во сторон многоугольника");
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            Point point = new Point();
            this.countOfPoints.add(point);
        }
        System.out.println("Многоугольник создан!");
    }

    @Override
    void print() {
        System.out.println("Это многоугольник с " + countOfPoints.size() + " cторонами");
    }

    @Override
    void move() {
        Point center = this.getCenterOfGravity();
        double x1 = getRandomNumber(-99, 100);
        double y1 = getRandomNumber(-99, 100);
        Point centerBefore = new Point(x1, y1);

        for (Point point : this.countOfPoints) {
            double divX = point.getX() - center.getX();
            double divY = point.getY() - center.getY();
            point.setX(centerBefore.getX() + divX);
            point.setY(centerBefore.getY() + divY);
        }

    }

    @Override
    void scale(double ratio) {
        for (Point point : this.countOfPoints) {
            point.setX(point.getX() * ratio);
            point.setY(point.getY() * ratio);
        }
    }

    @Override
    double square() {
        double sum1 = 0;
        for (int i = 0; i < countOfPoints.size() - 1; i++) {
            sum1 = sum1 + countOfPoints.get(i).getX() * countOfPoints.get(i + 1).getY();
        }
        sum1 += countOfPoints.get(countOfPoints.size() - 1).getX() * countOfPoints.get(0).getY();
        double sum2 = 0;
        for (int i = 0; i < countOfPoints.size() - 1; i++) {
            sum2 = sum2 - countOfPoints.get(i).getY() * countOfPoints.get(i + 1).getX();
        }
        sum2 -= countOfPoints.get(countOfPoints.size() - 1).getY() * countOfPoints.get(0).getX();
        return Math.abs(0.5 * (sum1 - sum2));
    }

    Point getCenterOfGravity() {
        double sumX = 0;
        double sumY = 0;
        for (int i = 0; i < countOfPoints.size(); i++) {
            sumX = sumX + countOfPoints.get(i).getX();
            sumY = sumY + countOfPoints.get(i).getY();
        }
        double x0 = sumX / countOfPoints.size();
        double y0 = sumY / countOfPoints.size();
        return new Point(x0, y0);
    }

}