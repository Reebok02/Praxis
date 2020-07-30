package practicesb.day2;

import java.util.concurrent.ThreadLocalRandom;

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
    public void print() {
        System.out.println("Это треугольник с координатами (" + this.point1.getX() + ";" + this.point1.getY() + "), " + "(" + this.point2.getX() + ";" + this.point2.getY() + "), " + "(" + this.point3.getX() + ";" + this.point3.getY() + ")");
    }

    //перемещение в случайную точку
    @Override
    public void move() {
        Point center = this.getCenterOfGravity();
        double x1 = ThreadLocalRandom.current().nextDouble(-99, 100);
        double y1 = ThreadLocalRandom.current().nextDouble(-99, 100);
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
    public void scale(double ratio) {
        point1.setX(point1.getX() * ratio);
        point1.setY(point1.getY() * ratio);
        point2.setX(point2.getX() * ratio);
        point2.setY(point2.getY() * ratio);
        point3.setX(point3.getX() * ratio);
        point3.setY(point3.getY() * ratio);
    }

    @Override
    public double square() {
        double half = perimetr() / 2;
        double ab = Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2) + Math.pow((point2.getY() - point1.getY()), 2));
        double bc = Math.sqrt(Math.pow((point3.getX() - point2.getX()), 2) + Math.pow((point3.getY() - point2.getY()), 2));
        double ca = Math.sqrt(Math.pow((point3.getX() - point1.getX()), 2) + Math.pow((point3.getY() - point1.getY()), 2));
        double square = Math.sqrt(half * (half - ab) * (half - bc) * (half - ca));
        return square;

    }

    public double perimetr() {
        double ab = Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2) + Math.pow((point2.getY() - point1.getY()), 2));
        double bc = Math.sqrt(Math.pow((point3.getX() - point2.getX()), 2) + Math.pow((point3.getY() - point2.getY()), 2));
        double ca = Math.sqrt(Math.pow((point3.getX() - point1.getX()), 2) + Math.pow((point3.getY() - point1.getY()), 2));
        return ab + bc + ca;
    }

    public Point getCenterOfGravity() {
        double x0 = ((this.point1.getX() + this.point2.getX() + this.point3.getX()) / 3);
        double y0 = ((this.point1.getY() + this.point2.getY() + this.point3.getY()) / 3);
        return new Point(x0, y0);
    }

    public Triangle rotate(double degree) {
        double radian = degree * (Math.PI / 180);
        Point center = this.getCenterOfGravity();
        //перемещаем координату окружности в точку (0,0)
        this.point1.setX(this.point1.getX() - center.getX());
        this.point1.setY(this.point1.getY() - center.getY());
        this.point2.setX(this.point2.getX() - center.getX());
        this.point2.setY(this.point2.getY() - center.getY());
        this.point3.setX(this.point3.getX() - center.getX());
        this.point3.setY(this.point3.getY() - center.getY());
        //поворачиваем фигуру
        this.point1.setX(this.point1.getX() * Math.cos(radian) - this.point1.getY() * Math.sin(radian));
        this.point1.setY((this.point1.getX() * Math.sin(radian) + this.point1.getY() * Math.cos(radian)));

        this.point2.setX(this.point2.getX() * Math.cos(radian) - this.point2.getY() * Math.sin(radian));
        this.point2.setY((this.point2.getX() * Math.sin(radian) + this.point2.getY() * Math.cos(radian)));

        this.point3.setX(this.point3.getX() * Math.cos(radian) - this.point3.getY() * Math.sin(radian));
        this.point3.setY((this.point3.getX() * Math.sin(radian) + this.point3.getY() * Math.cos(radian)));

        //возвращаем фигуру на место
        this.point1.setX(this.point1.getX() + center.getX());
        this.point1.setY(this.point1.getY() + center.getY());
        this.point2.setX(this.point2.getX() + center.getX());
        this.point2.setY(this.point2.getY() + center.getY());
        this.point3.setX(this.point3.getX() + center.getX());
        this.point3.setY(this.point3.getY() + center.getY());

        return this;
    }
}