package practicesb.day6and7.plugins;

import practicesb.day6and7.Plugins;

@Plugins
public class AnyClass2 extends BaseClass{
    @Override
    public void cool(String arg){
        System.out.println("AnyClass2 сool run with " + arg);
    }

    public void foo2(String arg){
        System.out.println("AnyClass2 foo2 run with " + arg);
    }

    public void foo3(String arg){
        System.out.println("AnyClass2 foo3 run with " + arg);
    }
}
