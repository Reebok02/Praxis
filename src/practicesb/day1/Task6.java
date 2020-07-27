package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task6 {
    public static void main(String[] args) throws IOException {
        final double STRENGTH = 0.17;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        double weightOnEarth = Double.parseDouble(input.readLine());
        double weightOnMoon = weightOnEarth * STRENGTH;
        System.out.println("Вес человека на Луне будет равен " + weightOnMoon);
    }
}
