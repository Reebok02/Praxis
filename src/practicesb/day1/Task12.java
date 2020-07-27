package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task12 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку");
        String str = input.readLine();
        System.out.println("Введите индекс символа, который нужно удалить");
        int n = Integer.parseInt(input.readLine());
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.deleteCharAt(n);
        System.out.println("Результат: ");
        System.out.println(stringBuilder.toString());
    }
}
