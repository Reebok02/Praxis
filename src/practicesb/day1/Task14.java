package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task14 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int a = 65;
        int z = 90;
        int res = getRandomNumber(a ,z);
        char user ;
        int userInt = 0;
        while (true) {
            user = input.readLine().charAt(0);
            userInt = (int) user;
            if (user > res) {
                System.out.println("You're too high");
            } else if (user < res) {
                System.out.println("You're too low");
            } else {
                System.out.println("Right");
                break;
            }
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}

