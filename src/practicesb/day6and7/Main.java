package practicesb.day6and7;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        ArrayList<Double> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            double n = Math.round(ThreadLocalRandom.current().nextDouble(1, 10));
            list1.add(n);
        }    //заполнение листа

        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            int n = Math.round(ThreadLocalRandom.current().nextInt(10, 20));
            set1.add(n);
        }          //заполнение сета
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Vasya");
        map1.put(2, "Petya");

        int[] arr1 = {1 , 2 , 3 , 4, 5};
        int[] arr2 = {5 , 7 , 8 , 9, 10};


        Example test = new Example("Ivanov", "Ivan", 20, list1, set1, map1);

        test.setArray(arr1);

        ArrayList<Double> list2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            double n = Math.round(ThreadLocalRandom.current().nextDouble(1, 10));
            list2.add(n);
        }             //заполнение листа

        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            int n = Math.round(ThreadLocalRandom.current().nextInt(10, 20));
            set2.add(n);
        }              //заполнение сета

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(3, "Roma");
        map2.put(4, "Valera");

        Example test1 = new Example("Petrov", "Petr", 10, list2, set2, map2);

        test1.setArray(arr2);

        System.out.println("Мапы до:");
        test.getMap().entrySet().forEach(System.out::println);
        System.out.println();
        test1.getMap().entrySet().forEach(System.out::println);
        System.out.println();
        copyConteiner(test, test1);
        System.out.println("Мапы после:");
        test.getMap().entrySet().forEach(System.out::println);
        System.out.println();
        test1.getMap().entrySet().forEach(System.out::println);
        System.out.println();

        for (int i : test1.getArray()) {
            System.out.print(i + " ");
        }
        System.out.println("Проверка ссылок " +
                "\nу листа: " + (test.getList() == test1.getList()) +
                "\nу сета: " + (test.getSet() == test1.getSet()) +
                "\nу мапы: " + (test.getMap() == test1.getMap()));
        System.out.println(test.getArray() == test1.getArray());


    }

    public static void showMethods(Object o) {
        Method[] methods = o.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.toString());
        }
    }

    @RunMe
    public static void isFly(Object o) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = o.getClass().getDeclaredMethods();

        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getName().equals("fly")) {
                method.invoke(o);
            }
        }
    }


    public static void copyingObjectsByFieldNames(Object source, Object dist) throws NoSuchFieldException, IllegalAccessException {
        {
            Field[] sourceFields = source.getClass().getDeclaredFields();
            for (Field sourceField : sourceFields) {
                Field distField = dist.getClass().getDeclaredField(sourceField.getName());
                if (sourceField.getType().equals(distField.getType())) {
                    sourceField.setAccessible(true);
                    distField.setAccessible(true);
                    distField.set(dist, sourceField.get(source));
                }
            }
        }
    }

    public static void copyConteiner(Object first, Object second) throws NoSuchFieldException, IllegalAccessException {
        Class<?> firstClass = first.getClass();
        Class<?> secondClass = second.getClass();
        Field[] firstFields = firstClass.getDeclaredFields();    //поля первого

        for (Field firstField : firstFields) {
            Field secondField = secondClass.getDeclaredField(firstField.getName());
            firstField.setAccessible(true);
            secondField.setAccessible(true);
            if (firstField.getType().equals(secondField.getType())) {
                if (!(firstField.getType().equals(String.class) || firstField.getType().isPrimitive())) {
                    if (List.class.isAssignableFrom(firstField.getType())) {
                        List list = (List) firstField.get(first);
                        List newList = new ArrayList();
                        Collections.addAll(newList, list);
                        secondField.set(second, newList);
                    } else if (Set.class.isAssignableFrom(firstField.getType())) {
                        Set set = (Set) firstField.get(first);
                        Set newSet = new HashSet();
                        Collections.addAll(newSet, set);
                        secondField.set(second, newSet);
                    } else if (Map.class.isAssignableFrom(firstField.getType())) {
                        Map map = (Map) firstField.get(first);
                        HashMap newMap = new HashMap(map);
                        secondField.set(second, newMap);
                    } else if (firstField.getType().isArray()){
                        
                    }

                }
            }
        }

    }
}