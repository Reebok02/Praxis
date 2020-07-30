package practicesb.day2;

public class MainTask2 {
    public static void main(String[] args) {
        Complex<Integer> complex = new Complex<>(30, 50);
        Complex<Integer> complex1 = new Complex<>(6,2);
        Complex<Double> complex2 = new Complex<>(3.0, 5.0);
        Complex<Double> complex3 = new Complex<>(6.0, 2.0);

        complex.print();
        complex.sum(complex1).print();
        complex3.difference(complex2).print();
        complex.multiplication(complex1).print();
        complex.division(complex1).print();
    }
}
