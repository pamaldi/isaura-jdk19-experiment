package cloud.isaura.experimental.text;

public class TextBlock
{
    public static void main(String[] args)
    {
        String textBlock = """
                {"menu": {
                         "id": "file",
                         "value": "File",
                         "popup": {
                           "menuitem": [
                             {"value": "New", "onclick": "CreateNewDoc()"},
                             {"value": "Open", "onclick": "OpenDoc()"},
                             {"value": "Close", "onclick": "CloseDoc()"}
                           ]
                         }
                       }}
                """;
        System.out.println("Text block "+textBlock);
        String line="{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";
        System.out.println("line string "+line);

    }
}
