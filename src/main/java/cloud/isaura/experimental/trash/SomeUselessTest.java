package cloud.isaura.experimental.trash;

import java.math.BigDecimal;
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

        double a = 0.02;
        double b = 0.03;
        double c = b - a;
        System.out.println(c);

        BigDecimal _a = new BigDecimal("0.02");
        BigDecimal _b = new BigDecimal("0.03");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c);

        BigDecimal _a1 = new BigDecimal("0.02");
        System.out.println(_a1);
    }
}
