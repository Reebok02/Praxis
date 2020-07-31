package practicesb.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> group1 = new ArrayList<>(Arrays.asList("Анастасия", "Ксения", "Юрий"));
        List<String> group2 = new ArrayList<>(Arrays.asList("Антон", "Ксения", "Юлия"));
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Double> numbers2 = new ArrayList<>(Arrays.asList(1.5, 2.5, 3.5));
        List<String> nullList = null;
        List<String> emptyList = new ArrayList<>();

        boolean isBlank;

        isBlank = UtilClass.isBlank(nullList);

        if (!isBlank) {
            throw new AssertionError("Должно быть значение true");
        }

        isBlank = UtilClass.isBlank(emptyList);

        if (!isBlank) {
            throw new AssertionError("Должно быть значение true");
        }

        isBlank = UtilClass.isBlank(group1);

        if (isBlank) {
            throw new AssertionError("Должно быть значение false");
        }

        String lastElem = (String) UtilClass.getLastElem(group1);

        if (!"Юрий".equals(lastElem)) {
            throw new AssertionError("Последний в списке должен быть Юрий");
        }

        double lastNum = (double) UtilClass.getLastElem(numbers1);

        if (lastNum != 3) {
            throw new AssertionError("Последним в списке должен быть 3");
        }

        String name = (String) UtilClass.findElem(group1, "Ксения");

        if (!"Ксения".equals(name)) {
            throw new AssertionError("Найденным должна быть Ксения");
        }

        int num = (int) UtilClass.findElem(numbers1, 2);

        if (num != 2) {
            throw new AssertionError("Найденным должна быть 2");
        }

        String nullName = (String) UtilClass.findElem(group1, "Кирилл");

        if (nullName != null) {
            throw new AssertionError("Кирилла в списке нет, должен вернуться null");
        }

        List<String> union = UtilClass.union(group1, group2);

        if (group1.size() != 3 || group2.size() != 3) {
            throw new AssertionError("Изначальные списки не должны измениться");
        }

        if (union.size() != 6
                || !union.containsAll(Arrays.asList("Анастасия", "Ксения", "Юрий", "Антон", "Ксения", "Юлия"))
        ) {
            throw new AssertionError("ответ union содержит неправильный список имен");
        }

        List<String> cutGroup = UtilClass.removeAll(group1, group2);

        if (group1.size() != 3 || group2.size() != 3) {
            throw new AssertionError("Изначальные списки не должны измениться");
        }

        if (cutGroup.size() != 2
                || !cutGroup.containsAll(Arrays.asList("Анастасия", "Юрий"))
                || cutGroup.contains("Ксения")) {
            throw new AssertionError("Ответ cutGroup содержит неправильный список имен");
        }

        double sum = UtilClass.sum(numbers1, numbers2);

        if (sum != 13.5) {
            throw new AssertionError("Ответ должен быть 13.5");
        }

        System.out.print("Поздравляю! Задание выполнено");
    }
}