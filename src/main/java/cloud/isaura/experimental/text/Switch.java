package cloud.isaura.experimental.text;

public class Switch
{

    public static void main(String[] args)
    {
        String message = howManyArguments(args);
        System.out.println("how many args "+message);

        printHowManyArguments(args);
    }

    private static String howManyArguments(String[] args)
    {
        return switch (args.length)
        {
            case 0 -> "No arguments";
            case 1 -> "One argument";

            default ->
            {
                int n = args.length;
                yield n + " arguments";
            }
        };
    }

    private static void printHowManyArguments(String[] args)
    {
        System.out.println("println how many args"+
        switch (args.length)
        {
            case 0 -> "No arguments";
            case 1 -> "One argument";

            default ->
            {
                int n = args.length;
                yield n + " arguments";
            }
        }
        );
    }
}
