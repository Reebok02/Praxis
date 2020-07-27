package practicesb.day1;

public class Task16 {
    public static void main(String[] args) {
        final int TABLE = 50_000;
        int count = 0;
        for (int i = 2; i < TABLE; i++){
            if (String.valueOf(i).indexOf('2') != -1){
                count++;
            }
        }
        System.out.println(count);

    }
}
