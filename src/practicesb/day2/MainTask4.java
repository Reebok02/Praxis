package practicesb.day2;


public class MainTask4 {
    public static void main(String[] args) {
        Circle circle = new Circle(0, 0, 3);
        Circle circle1 = new Circle(0,1.5,1.4);
        System.out.println(circle.isCircle(circle1));
    }
}