package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task15 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите переменную a ");
        double a = Double.parseDouble(input.readLine());
        System.out.println("Введите переменную b ");
        double b = Double.parseDouble(input.readLine());
        System.out.println("Введите переменную c ");
        double c = Double.parseDouble(input.readLine());

        double dis = Math.pow(b, 2) - 4 * a * c;
        if (dis > 0){
            double x1 = ((-b + Math.sqrt(dis)) /(2 * a));
            double x2 = ((-b - Math.sqrt(dis)) /(2 * a));
            System.out.println("Корни уравнения: " + x1 + " и " + x2);
        } else if (dis == 0){
            double x = (- b / 2 * a);
            System.out.println("Корень уравнения: " + x);
        } else {
            System.out.println("Данной уравнение не именет действительных корней");
        }
    }


}
