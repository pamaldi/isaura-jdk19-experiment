package cloud.isaura.experimental.cellularautomata.simple.model;

public class GenerationRule
{

    private int[] ruleset;

    public GenerationRule(int[] ruleset)
    {
        this.ruleset = ruleset;
    }

    public int applyRule(int a, int b, int c)
    {
        //System.out.println("a "+a+" b "+b+" c "+c);
        if (a == 1 && b == 1 && c == 1) return ruleset[0];
        else if (a == 1 && b == 1 && c == 0) return ruleset[1];
        else if (a == 1 && b == 0 && c == 1) return ruleset[2];
        else if (a == 1 && b == 0 && c == 0) return ruleset[3];
        else if (a == 0 && b == 1 && c == 1) return ruleset[4];
        else if (a == 0 && b == 1 && c == 0) return ruleset[5];
        else if (a == 0 && b == 0 && c == 1) return ruleset[6];
        else if (a == 0 && b == 0 && c == 0) return ruleset[7];
        return 0;
    }
}
