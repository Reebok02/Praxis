package practicesb.day8;

public class TestMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(15, 12));
        System.out.println(calculator.mul(15, 0));
        System.out.println(calculator.sub(5, 0));

        CalculatingTheRootsOfASquareEdition roots = new CalculatingTheRootsOfASquareEdition(1,-12,36);
        roots.solve().forEach(System.out::println);

    }
}
