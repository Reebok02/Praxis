package practicesb.day2;

public class MainTask3 {
    private int x;
    private int y;
    private int z;

    public MainTask3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    //разность векторов
    protected MainTask3 difference(MainTask3 vector){
        int x3 = this.getX() - vector.getX();
        int y3 = this.getY() - vector.getY();
        int z3 = this.getZ() - vector.getZ();
        MainTask3 result = new MainTask3(x3, y3, z3);
        return result;
    }

    //сумма векторов
    protected MainTask3 sum(MainTask3 vector){
        int x3 = this.getX() + vector.getX();
        int y3 = this.getY() + vector.getY();
        int z3 = this.getZ() + vector.getZ();
        MainTask3 result = new MainTask3(x3, y3, z3);
        return result;
    }

    //скалярное произведение векторов
    protected int scalar(MainTask3 vector){
        int result = this.getX()*vector.getX() + this.getY()*vector.getY() + this.getZ()*vector.getZ();
        return result;
    }

    //длина вектора
    protected double lenght(){
        double result = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
        return result;
    }

    @Override
    public String toString() {
        return "{" + this.getX() + "; " + this.getY() + "; " + this.getZ() + "}";
    }

    public static void main(String[] args) {
        MainTask3 vector = new MainTask3(1,2,3);
        MainTask3 vector1 = new MainTask3(3,2,1);
        System.out.println("После разности вектор имеет координаты: "+ vector.difference(vector1));
        System.out.println("После суммы вектор имеет координаты: "+ vector.sum(vector1));
        System.out.println("Скалярное произведение вектора равно: " + vector.scalar(vector1));
        System.out.println("Длина вектора равна: " + vector.lenght());
        System.out.println("Длина вектора равна: " + vector1.lenght());

    }
}
