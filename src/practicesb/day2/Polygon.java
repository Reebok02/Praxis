package practicesb.day2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Polygon extends Figure {
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
    public void print() {
        System.out.println("Это многоугольник с " + countOfPoints.size() + " cторонами");
    }

    @Override
    public void move() {
        Point center = this.getCenterOfGravity();
        double x1 = ThreadLocalRandom.current().nextDouble(-99,100);
        double y1 = ThreadLocalRandom.current().nextDouble(-99,100);
        Point centerBefore = new Point(x1, y1);

        for (Point point : this.countOfPoints) {
            double divX = point.getX() - center.getX();
            double divY = point.getY() - center.getY();
            point.setX(centerBefore.getX() + divX);
            point.setY(centerBefore.getY() + divY);
        }

    }

    @Override
    public void scale(double ratio) {
        for (Point point : this.countOfPoints) {
            point.setX(point.getX() * ratio);
            point.setY(point.getY() * ratio);
        }
    }

    @Override
    public double square() {
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

    public Point getCenterOfGravity() {
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