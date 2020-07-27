package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task10 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите кол-во n членов Фибоначчи, которое необходимо вывести");
        int n = Integer.parseInt(input.readLine());
        ArrayList<Long> list = new ArrayList<>();
        list.add((long) 0);
        list.add((long) 1);
        for (int i = 2; i < n; i++){
            list.add(list.get(i-2) + list.get(i-1));
        }
        System.out.println("Результат: ");
        for (Long temp : list){
            System.out.println(temp);
        }
    }
}
