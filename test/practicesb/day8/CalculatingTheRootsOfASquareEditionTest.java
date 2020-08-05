package day8;

import practicesb.day8.CalculatingTheRootsOfASquareEdition;
import org.junit.Test;
import practicesb.day8.SolveException;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CalculatingTheRootsOfASquareEditionTest {
    @Test
    public void testRootsInt1(){
        ArrayList<Double> list = new ArrayList<>();
        CalculatingTheRootsOfASquareEdition roots = new CalculatingTheRootsOfASquareEdition(2, -5,0);
        list.addAll(roots.solve());
        double delta = 0.00000001d;
        double x1 = list.get(0);
        double x2 = list.get(1);
        assertEquals(2.5d, x1, delta);
        assertEquals(0.0d, x2, delta);

    }

    @Test
    public void testRootsInt2(){
        ArrayList<Double> list = new ArrayList<>();
        CalculatingTheRootsOfASquareEdition roots = new CalculatingTheRootsOfASquareEdition(1, 0,-36);
        list.addAll(roots.solve());
        double delta = 0.00000001d;
        double x1 = list.get(0);
        double x2 = list.get(1);
        assertEquals(6d, x1, delta);
        assertEquals(-6d, x2, delta);
    }

    @Test
    public void testRootsInt3(){
        ArrayList<Double> list = new ArrayList<>();
        CalculatingTheRootsOfASquareEdition roots = new CalculatingTheRootsOfASquareEdition(4, -4,3);
        try {
        list.addAll(roots.solve());
            double delta = 0.00000001d;
            double x1 = list.get(0);
            double x2 = list.get(1);
        } catch (SolveException e){
            assertTrue(true);
        }
    }
    @Test
    public void testRootsInt4(){
        ArrayList<Double> list = new ArrayList<>();
        CalculatingTheRootsOfASquareEdition roots = new CalculatingTheRootsOfASquareEdition(1, 10,25);
        list.addAll(roots.solve());
        double delta = 0.00000001d;
        double x1 = list.get(0);
        assertEquals(-5d, x1, delta);
    }

}
