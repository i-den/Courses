import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEveryThirdLine {

    private static final String INPUT_FILE = "C:\\Users\\iVan\\Downloads\\lab\\input.txt";
    private static final String OUTPUT_FILE = "C:\\Users\\iVan\\Downloads\\lab\\output.txt";

    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE))
        ) {
            int lineCnt = 1;
            String currLine;
            while ((currLine = bufferedReader.readLine()) != null) {
                if (lineCnt % 3 == 0) {
                    bufferedWriter.write(currLine);
                    bufferedWriter.write(System.lineSeparator());
                }
                lineCnt++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}