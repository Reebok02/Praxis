package practicesb.day6and7;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import practicesb.day6and7.testClasses.*;

public class AnnotationExample {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        System.out.println("Все плагины: ");
        printAllPlugins();
        System.out.println("\n" +
                "Методы с аннотацией @RunMe в классе TestClass1: ");
        TestClass1 testClass1 = new TestClass1();
        run(testClass1);


    }

    public static void printAllPlugins() {
        Reflections reflections = new Reflections("practicesb.day6and7");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Plugins.class);
        for (Class<?> clazz : classes){
            System.out.println(clazz.getCanonicalName());
        }
    }

    public static void run(TestClass1 testClass1){
        for (Method m : testClass1.getClass().getDeclaredMethods()){
            if (m.isAnnotationPresent(RunMe.class)){
                try {
                    m.invoke(testClass1);
                } catch (IllegalAccessException | InvocationTargetException exception){
                    System.out.println("Invalid @Run: " + m);
                }
            }
        }
    }

    public static void checkRunMe() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Reflections reflections = new Reflections("practicesb.day6and7");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Plugins.class);
        if (!(classes.isEmpty())){
            for (Class<?> clazz : classes){
                for (Method m : clazz.getDeclaredMethods()){
                    m.setAccessible(true);
                    if (m.isAnnotationPresent(RunMe.class)){
                        m.invoke(clazz.newInstance());
                    }
                }
            }
        }
    }
}
