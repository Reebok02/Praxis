package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task8 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean isPrime = true;
        int num = Integer.parseInt(input.readLine());
        int temp;
        for (int i = 2; i <= num / 2; i++){
            temp = num % i;
            if (temp == 0){
                isPrime = false;
                break;
            }
        }
        if (isPrime){
            System.out.println("Введенное число - простое!");
        } else {
            System.out.println("Введенное число - составное!");
        }

    }
}
