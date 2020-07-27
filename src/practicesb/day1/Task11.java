package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task11 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первое число");
        int a = Integer.parseInt(input.readLine());
        System.out.println("Введите второе число, оно должно быть больше первого!");
        int b = Integer.parseInt(input.readLine());
        if (b > a) {
            int c = (int) (Math.random() * ((b + 1) - a) + a);
            System.out.println("Случайное число: " + c);
        } else {
            System.out.println("Условие ввода чисел не было выполнено");
        }
    }
}
