package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int i = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (num >= i){
            if (num % i == 0){
                list.add(i);
            }
            i++;
        }
        System.out.println("Положительные делители числа " + num + ": ");
        for (int j = 0; j < list.size(); j++){
            System.out.print(list.get(j) + " ");
        }
    }
}
