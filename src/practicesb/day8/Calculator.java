package practicesb.day8;

public class Calculator<T extends Number> {

    public T sum(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Long && b instanceof Long) {
            return (T) Long.valueOf(a.longValue() + b.longValue());
        } else if (a instanceof Float && b instanceof Float) {
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        } else {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        }
    }

    public T sub(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        } else if (a instanceof Long && b instanceof Long) {
            return (T) Long.valueOf(a.longValue() - b.longValue());
        } else if (a instanceof Float && b instanceof Float) {
            return (T) Float.valueOf(a.floatValue() - b.floatValue());
        } else {
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        }
    }

    public T mul(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        } else if (a instanceof Long && b instanceof Long) {
            return (T) Long.valueOf(a.longValue() * b.longValue());
        } else if (a instanceof Float && b instanceof Float) {
            return (T) Float.valueOf(a.floatValue() * b.floatValue());
        } else {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        }
    }

    public T div(T a, T b) {
        try {
            if (a instanceof Integer && b instanceof Integer) {
                return (T) Integer.valueOf(a.intValue() / b.intValue());
            } else if (a instanceof Long && b instanceof Long) {
                return (T) Long.valueOf(a.longValue() / b.longValue());
            } else if (a instanceof Float && b instanceof Float) {
                return (T) Float.valueOf(a.floatValue() / b.floatValue());
            } else {
                return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Деление на ноль");
        }
    }
}
