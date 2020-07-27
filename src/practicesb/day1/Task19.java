package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task19 {
    public static void main(String[] args) throws IOException {
        final String[] ROM = {"I","IV","V","IX","X","XL","L","XC","C"};
        final int[] AR = {1,4,5,9,10,40,50,90,100};
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите натуральное число от 1-го до 100");
        int n = Integer.parseInt(input.readLine());
        StringBuilder rom = new StringBuilder();
        for (int i = 8; i >= 0; i--){
            while (n >= AR[i]) {
                n = n - AR[i];
                rom.append(ROM[i]);
            }
        }
        System.out.println("Число в римской записи: " + rom);
        }
    }

