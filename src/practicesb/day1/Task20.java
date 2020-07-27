package practicesb.day1;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task20 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите кол-во строк");
        int n = Integer.parseInt(input.readLine());
        System.out.println("Введите данные строк");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            String str = input.readLine();
            ArrayList<String> list = new ArrayList<>();
            for(String temp : str.split(" ")){
                list.add(temp);
            }
            int sum = 0;
            if (list.size() != 1){
                for (int j = 1; j < list.size(); j++){
                    sum = sum + Integer.parseInt(list.get(j));
                }
                map.put(list.get(0), sum);
            } else {
                map.put(list.get(0), 0);
            }
            /*Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()){
                Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) iter.next();
                System.out.print("Key: " + pair.getKey() + " ");
                System.out.println("Value: " + pair.getValue());
            }*/
        }
        System.out.println("Отсортированный вариант: ");
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

    }
}
