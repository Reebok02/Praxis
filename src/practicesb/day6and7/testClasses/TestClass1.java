package practicesb.day6and7.testClasses;

import practicesb.day6and7.Plugins;
import practicesb.day6and7.RunMe;

@Plugins
public class TestClass1 {
    public TestClass1() {
    }

    @RunMe
    public void fly(){
        System.out.println("Запущен метод fly() в классе TestClass1");
    }

    public void breath(){
        System.out.println("Запущен метод breath() в классе TestClass1");
    }

    @RunMe
    public void gun(){
        System.out.println("Запущен метод gun() в классе TestClass1");
    }
}
