package practicesb.day2;

public class Complex<T extends Number> {
    private T x;
    private T y;

    public Complex(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public void print() {
        System.out.println("Это комплексное число: " + this.x + definitionOfSign(this) + this.y + "i");
    }

    //определение знака у числа y
    private String definitionOfSign(Complex<T> complex) {
        if (this.y instanceof Integer) {
            if (complex.y.intValue() >= 0) {
                return "+";
            }
            return "";
        } else {
            if (complex.y.doubleValue() >= 0) {
                return "+";
            }
            return "";
        }
    }

    public Complex<T> sum(Complex<T> complex) {
        if (this.y instanceof Integer) {
            Integer x1 = this.x.intValue() + complex.x.intValue();
            Integer y1 = this.y.intValue() + complex.y.intValue();
            return new Complex<T>((T) x1, (T) y1);
        } else {
            Double x1 = this.x.doubleValue() + complex.x.doubleValue();
            Double y1 = this.y.doubleValue() + complex.y.doubleValue();
            return new Complex<T>((T) x1, (T) y1);
        }
    }

    public Complex<T> difference(Complex<T> complex) {
        if (this.y instanceof Integer) {
            Integer x1 = this.x.intValue() - complex.x.intValue();
            Integer y1 = this.y.intValue() - complex.y.intValue();
            return new Complex<T>((T) x1, (T) y1);
        } else {
            Double x1 = this.x.doubleValue() - complex.x.doubleValue();
            Double y1 = this.y.doubleValue() - complex.y.doubleValue();
            return new Complex<T>((T) x1, (T) y1);
        }
    }

    public Complex<T> multiplication(Complex<T> complex) {
        if (this.y instanceof Integer) {
            Integer x1 = ((this.x.intValue() * complex.x.intValue()) + (this.y.intValue() * complex.y.intValue() * -1));
            Integer y1 = (this.y.intValue() * complex.x.intValue() + this.x.intValue() * complex.y.intValue());
            return new Complex<T>((T) x1, (T) y1);
        } else {
            Double x1 = ((this.x.doubleValue() * complex.x.doubleValue()) + (this.y.doubleValue() * complex.y.doubleValue() * -1));
            Double y1 = (this.y.doubleValue() * complex.x.doubleValue() + this.x.doubleValue() * complex.y.doubleValue());
            return new Complex<T>((T) x1, (T) y1);
        }
    }

    public Complex<T> division(Complex<T> complex) {
        if (this.y instanceof Integer) {
            Integer x1 = ((this.x.intValue() * complex.x.intValue()) + (this.y.intValue() * complex.y.intValue()))
                    / (int) (Math.pow(complex.x.intValue(), 2) + Math.pow(complex.y.intValue(), 2));
            Integer y1 = ((this.y.intValue() * complex.x.intValue()) + (this.x.intValue() * complex.y.intValue() * -1))
                    / (int) (Math.pow(complex.x.intValue(), 2) + Math.pow(complex.y.intValue(), 2));
            return new Complex<T>((T) x1, (T) y1);
        } else {
            Double x1 = ((this.x.doubleValue() * complex.x.doubleValue()) + (this.y.doubleValue() * complex.y.doubleValue()))
                    / (Math.pow(complex.x.doubleValue(), 2) + Math.pow(complex.y.doubleValue(), 2));
            Double y1 = ((this.y.doubleValue() * complex.x.doubleValue()) + (this.x.doubleValue() * complex.y.doubleValue() * -1))
                    / (Math.pow(complex.x.doubleValue(), 2) + Math.pow(complex.y.doubleValue(), 2));
            return new Complex<T>((T) x1, (T) y1);
        }
    }


}
