package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            Long num = Long.parseLong(input.readLine());
            String str = num.toString();
            long sum = 0;
            for (int i = 0; i < str.length(); i++){
                sum += Character.getNumericValue(str.charAt(i));
            }
            System.out.println("Сумма всех цифр числа "+ num + " равна " + sum);
        } catch (NumberFormatException e){
            System.out.println("Введено некорректное число или оно выходит за диапазон значений Long");
        }
    }
}


