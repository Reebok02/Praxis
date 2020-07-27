package practicesb.day1;

public class Task17 {
    public static void main(String[] args) {
        final int ROWS = 6;
        final int COLUMNS = 7;
        System.out.println("Исходный массив: ");
        int[][] arr = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                arr[i][j] = (int) getRandomNumber(0, 10);
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = COLUMNS -1; j > 0; j--) {
                if (arr[i][j] > arr[i][j - 1]) {
                    int temp = arr[i][j-1];
                    arr[i][j-1] = arr[i][j];
                    arr[i][j] = temp;

                }
            }
        }
        System.out.println();
        System.out.println("Преобразованный массив: ");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
