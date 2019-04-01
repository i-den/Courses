import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class LineNumbers {

    private static final String INPUT_FILE = "enterHere";
    private static final String OUTPUT_FILE = "enterHere";

    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE))
        ) {
            String line;
            int lineCnt = 1;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(String.format("%d. %s%n", lineCnt, line));
                lineCnt++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}