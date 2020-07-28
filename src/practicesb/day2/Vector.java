package practicesb.day2;

public class Vector {
    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
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
    protected Vector difference(Vector vector){
        int x3 = this.getX() - vector.getX();
        int y3 = this.getY() - vector.getY();
        int z3 = this.getZ() - vector.getZ();
        Vector result = new Vector(x3, y3, z3);
        return result;
    }

    //сумма векторов
    protected Vector sum(Vector vector){
        int x3 = this.getX() + vector.getX();
        int y3 = this.getY() + vector.getY();
        int z3 = this.getZ() + vector.getZ();
        Vector result = new Vector(x3, y3, z3);
        return result;
    }

    //скалярное произведение векторов
    protected int scalar(Vector vector){
        int result = this.getX()*vector.getX() + this.getY()*vector.getY() + this.getZ()*vector.getZ();
        System.out.print("Скалярное произведение вектора равно: ");
        return result;
    }

    //длина вектора
    protected double lenght(){
        double result = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
        System.out.print("Длина вектора равна: ");
        return result;
    }

    @Override
    public String toString() {
        return "вектор имеет координаты: " + "{" + this.getX() + "; " + this.getY() + "; " + this.getZ() + "}";
    }

    public static void main(String[] args) {
        Vector vector = new Vector(1,2,3);
        Vector vector1 = new Vector(3,2,1);
        System.out.println("После разности " + vector.difference(vector1));
        System.out.println("После суммы " + vector.sum(vector1));
        System.out.println(vector.scalar(vector1));
        System.out.println(vector.lenght());
        System.out.println(vector1.lenght());

    }
}
