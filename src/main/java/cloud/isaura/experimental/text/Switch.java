package cloud.isaura.experimental.text;

public class Switch
{

    public static void main(String[] args)
    {
        String message = switch (args.length) {
            case 0 -> "No arguments";
            case 1 -> "One argument";

            default -> {
                int n = args.length;
                yield n + " arguments";
            }
        };
    }
}
