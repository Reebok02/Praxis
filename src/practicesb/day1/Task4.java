package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        StringBuilder stringBuilder = new StringBuilder(str).reverse();
        try {
            int num1 = Integer.parseInt(str);
            int num2 = Integer.parseInt(stringBuilder.toString());
            if (num1 == num2){
                System.out.println("Введённое число - палиндром");
            } else {
                System.out.println("Введённое число не является палиндромом");
            }
        } catch (NumberFormatException e){
            System.out.println("Введена некорректная строка");
        }
    }
}
