package practicesb.day2;

public class Complex {
    private double x;
    private double y;

    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void print(double x, double y){
        System.out.println("Это комплексное число: " + this.x );
    }
}
