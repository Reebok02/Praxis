package practicesb.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Task13 {
    public static void main(String[] args)throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        System.out.println("Введите размер необходимого массива ");
        int size = Integer.parseInt(input.readLine());
        double[] arr = new double[size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (random.nextInt() / 100000) - 15;
        }

        while (true) {
            showInterface();
            int num = Integer.parseInt(input.readLine());

            switch (num) {
                case 1:
                    System.out.println("Сгенерированный массив: ");
                    for (double temp : arr) {
                        System.out.println(temp);
                    }

                    break;
                case 2:
                    System.out.println("Введите индекс элемента для увеличения ");
                    try {
                        int index = Integer.parseInt(input.readLine());
                        arr[index] = 1.1 * arr[index];
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Недопустимое значение индекса");
                    }

                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Данной цифры в меню выбора нет");
            }
        }
    }
    static void showInterface () {
        System.out.println("Интерфейс");
        System.out.println("1. Вывести массив       " +
                "\n2. Увеличить элемент массива на 10  %   " +
                "\n3. Выход");
    }

}
