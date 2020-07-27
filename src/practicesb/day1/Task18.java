package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task18 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите одну из наименьших сторон a ");
        double a = Double.parseDouble(input.readLine());
        System.out.println("Введите одну из наименьших сторон b ");
        double b = Double.parseDouble(input.readLine());
        System.out.println("Введите наибольшую сторону c ");
        double c = Double.parseDouble(input.readLine());

        if ((a > b + c)||(b > a + c)){
            System.out.println("Треугольник с данными сторонами не существует");
        } else if (Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow(b, 2))){
            System.out.println("Треугольник прямоугольный");
        } else if (Math.pow(c, 2) < (Math.pow(a, 2) + Math.pow(b, 2))){
            System.out.println("Треугольник остроугольный");
        } else if (Math.pow(c, 2) > (Math.pow(b, 2) + Math.pow(a, 2))){
            System.out.println("Треугольник тупоугольный");
        }
    }
}
