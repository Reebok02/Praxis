package practicesb.day8;

import java.util.ArrayList;

public class CalculatingTheRootsOfASquareEdition {
    private ArrayList<Double> list = new ArrayList<>();
    private int a;
    private int b;
    private int c;

    private double x1, x2;

    public CalculatingTheRootsOfASquareEdition(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ArrayList<Double> solve(){
        ArrayList<Double> listRoots = new ArrayList<>();
        double dis = Math.pow(b, 2) - 4 * a * c;
        if (dis < 0){
            throw new SolveException("Вещественных корней нет");
        } else if (dis == 0){
            x1 = (-b) / (2 * a);
            listRoots.add(x1);
            return listRoots;
        } else {
            x1 = (-b + Math.sqrt(dis)) / (2 * a);
            x2 = (-b - Math.sqrt(dis)) / (2 * a);
            listRoots.add(x1);
            listRoots.add(x2);
            return listRoots;
        }
    }
}
