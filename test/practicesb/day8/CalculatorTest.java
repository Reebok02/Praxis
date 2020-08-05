package day8;

import org.junit.Test;
import practicesb.day8.Calculator;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class CalculatorTest {

    @Test
    public void calculatorTestIntSum() {
        Calculator<Integer> calculator = new Calculator<>();
        int a = calculator.sum(150, 12);

        assertEquals(162, a);
    }

    @Test
    public void calculatorTestLongSum() {
        Calculator<Long> calculator = new Calculator<>();
        long a = calculator.sum(1488L, 12L);
        assertEquals(1500L, a);
    }

    @Test
    public void calculatorTestFloatSum() {
        Calculator<Float> calculator = new Calculator<>();
        float accuracy = 0.0001f;
        float a = calculator.sum(6.57f, 1.43f);
        assertEquals(8f, a, accuracy);
    }

    @Test
    public void calculatorTestDoubleSum() {
        Calculator<Double> calculator = new Calculator<>();
        double accuracy = 0.00000001d;
        double a = calculator.sum(0.57d, 0.43d);
        assertEquals(1d, a, accuracy);
    }

    @Test
    public void calculatorTestIntSub() {
        Calculator<Integer> calculator = new Calculator<>();
        int a = calculator.sub(150, 10);
        assertEquals(140, a);
    }

    @Test
    public void calculatorTestLongSub() {
        Calculator<Long> calculator = new Calculator<>();
        long a = calculator.sub(1488L, 12L);
        assertEquals(1476L, a);
    }

    @Test
    public void calculatorTestFloatSub() {
        Calculator<Float> calculator = new Calculator<>();
        float accuracy = 0.0001f;
        float a = calculator.sub(6.57f, 1.43f);
        assertEquals(5.14f, a, accuracy);
    }

    @Test
    public void calculatorTestDoubleSub() {
        Calculator<Double> calculator = new Calculator<>();
        double accuracy = 0.00000001d;
        double a = calculator.sub(0.57d, 0.43d);
        assertEquals(0.14d, a, accuracy);
    }

    @Test
    public void calculatorTestIntMul() {
        Calculator<Integer> calculator = new Calculator<>();
        int a = calculator.mul(150, 10);
        assertEquals(1500, a);
    }

    @Test
    public void calculatorTestLongMul() {
        Calculator<Long> calculator = new Calculator<>();
        long a = calculator.mul(1488L, 10L);
        assertEquals(14880L, a);
    }

    @Test
    public void calculatorTestFloatMul() {
        Calculator<Float> calculator = new Calculator<>();
        float accuracy = 0.0001f;
        float a = calculator.mul(6.57f, 10f);
        assertEquals(65.7f, a, accuracy);
    }

    @Test
    public void calculatorTestDoubleMul() {
        Calculator<Double> calculator = new Calculator<>();
        double accuracy = 0.00000001d;
        double a = calculator.mul(0.57d, 10d);
        assertEquals(5.7d, a, accuracy);
    }

    @Test
    public void calculatorTestIntDiv() {
        Calculator<Integer> calculator = new Calculator<>();
        int a = calculator.div(150, 10);
        assertEquals(15, a);
    }

    @Test
    public void calculatorTestLongDiv() {
        Calculator<Long> calculator = new Calculator<>();
        long a = calculator.div(1480L, 10L);
        assertEquals(148L, a);
    }

    @Test
    public void calculatorTestFloatDiv() {
        Calculator<Float> calculator = new Calculator<>();
        float accuracy = 0.0001f;
        float a = calculator.div(6.57f, 10f);
        assertEquals(0.657f, a, accuracy);
    }

    @Test
    public void calculatorTestDoubleDiv() {
        Calculator<Double> calculator = new Calculator<>();
        double accuracy = 0.00000001d;
        double a = calculator.div(0.57d, 10d);
        assertEquals(0.057d, a, accuracy);
    }

    @Test
    public void calculatorTestDivByZero() {
        Calculator<Integer> calculator = new Calculator<>();
        try {
            int a = calculator.div(100, 0);
        } catch (ArithmeticException e){
            assertTrue(true);
        }
    }


}

