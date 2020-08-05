package practicesb.day6and7.testClasses;

import practicesb.day6and7.Plugins;
import practicesb.day6and7.RunMe;

@Plugins
public class TestClass2 {
    public TestClass2() {
    }

    private void fly(){
        System.out.println("Запущен метод fly() в классе TestClass1");
    }

    @RunMe
    private void breath(){
        System.out.println("Запущен метод breath() в классе TestClass1");
    }

    @RunMe
    private void gun(){
        System.out.println("Запущен метод gun() в классе TestClass1");
    }
}
