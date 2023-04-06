package cloud.isaura.experimental.trash;

import java.util.Optional;

public class SomeUselessTest
{

    public static void main(String[] args)
    {
        SomeUselessTest someUselessTest = new SomeUselessTest();
        someUselessTest.xxx();
    }
    public void xxx()
    {
        String cat = "cat";
        String s = Optional.ofNullable(cat).orElse("");
        System.out.println(s);
         cat = null;
         s = Optional.ofNullable(cat).orElse("");
        System.out.println("s "+ s);
    }
}
