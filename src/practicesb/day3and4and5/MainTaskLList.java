package practicesb.day3and4and5;

public class MainTaskLList {
    public static void main(String[] args) {
        LList<String> listStr = new LList<>();
        LList<Integer> listInt = new LList<>();
        listStr.add("String 1");
        listStr.add("String 2");
        listStr.add("String 4");
        System.out.println("listStr Size: " + listStr.size());
        System.out.println(listStr.contains("String 4"));
        System.out.println("listStr Empty? - " + listStr.isEmpty());
        listInt.add(1);
        listInt.add(10);
        listInt.add(15);
        System.out.println("listInt Size: " + listInt.size());
        System.out.println("listInt Empty? - " + listInt.isEmpty());

    }
}