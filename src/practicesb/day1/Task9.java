package practicesb.day1;

import java.util.ArrayList;

public class Task9 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < 101; i++){
            list.add(i);
        }
        System.out.println("Простые числа в диапазоне от 2 до 100: ");
        for (Integer temp : list){
            if(isPrime(temp)){
                System.out.print(temp + " ");
            }
        }
    }
    private static boolean isPrime(int value){
        for (int i = 2; i < value; i++){
            if (value % i == 0){
                return false;
            }
        }
        return true;
    }
}
