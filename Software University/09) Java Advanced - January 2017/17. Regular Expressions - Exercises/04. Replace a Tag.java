import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceATag {

    private static String strToEndInput = "END";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        try {
            String currLine;
            while (!strToEndInput.equals((currLine = reader.readLine()))) {
                output.append(currLine);
                output.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(output.toString().replaceAll("<a([\\s\\n]*?href=\".*?\")>((.|\\n|\\r)*?)<\\/a>", "[URL$1]$2[/URL]"));
    }
}