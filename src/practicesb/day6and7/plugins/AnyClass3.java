package practicesb.day6and7.plugins;

import practicesb.day6and7.Plugins;
import practicesb.day6and7.RunMe;

@Plugins
public class AnyClass3 {

    public void foo1(String arg){
        System.out.println("AnyClass1 foo1 run with " + arg);
    }
    @RunMe
    public void foo2(String arg){
        System.out.println("AnyClass1 foo2 run with " + arg);
    }

    public void foo3(String arg){
        System.out.println("AnyClass1 foo3 run with " + arg);
    }
}
