package practicesb.day2;

import java.util.Objects;
import java.util.Scanner;

public class Point {
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

    public void print() {
        System.out.println("Это точка с координатами (" + this.getX() + ";" + this.getY() + ")");
    }

    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //определение координатной четверти
    public int defirminingCoordinateQuarter() {
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
    public boolean isSymmetrical(Point point) {
        if (Math.abs(this.x) == Math.abs(point.x) && (Math.abs(this.y) == Math.abs(point.y))) {
            return true;
        } else {
            return false;
        }
    }

    public double getDistanceBetweenTwoPoints(Point point) {
        double result = Math.abs(Math.sqrt(Math.pow(point.getX() - this.getX(), 2) + Math.pow(point.getY() - this.getY(), 2)));
        return result;
    }

    public boolean isCollinear(Point point1, Point point2) {
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