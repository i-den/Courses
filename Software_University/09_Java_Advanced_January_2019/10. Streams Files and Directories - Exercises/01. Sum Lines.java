import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

    private static final String INPUT_DIR = "enterHere";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_DIR))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int lineASCIISum = 0;
                for (int i = 0; i < line.length(); i++) {
                    lineASCIISum += line.charAt(i);
                }
                System.out.println(lineASCIISum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}