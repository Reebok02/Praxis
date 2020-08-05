package practicesb.day6and7;

import java.util.*;

public class Example {
    private ArrayList<Double> list = new ArrayList<>();
    private Set<Integer> set = new HashSet<>();
    private Map<Integer, String> map = new HashMap<>();
    private int[] array = new int[5];

    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public Set<Integer> getSet() {
        return set;
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Example(String name, String surname, int age, ArrayList<Double> list, HashSet<Integer> set,Map<Integer, String> map) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.list = list;
        this.set = set;
        this.map = map;
    }

    public void setList(ArrayList<Double> list) {
        this.list = list;
    }

    public ArrayList<Double> getList() {
        return this.list;
    }

    public  Example(){
    }

    public void fly(){
        System.out.println("Метод fly() был вызван!");
    }
}
