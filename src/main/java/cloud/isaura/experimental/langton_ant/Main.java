package cloud.isaura.experimental.langton_ant;


public class Main
{

    public static void main(String[] args)
    {
        LangtonAntParameter langtonAntParameter = new LangtonAntParameter(1000,100,100, 50,50);
        LangtonAnt langtonAnt = new LangtonAnt(langtonAntParameter);
        langtonAnt.start();
        while (true)
        {

        }

    }
}
