import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {

    private static final String inputFile = "enterHere";
    private static final String outputFile = "enterHere";

    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(inputFile));
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputFile))
        ) {
            long currLineNum = 1;
            String currLine = bufferedReader.readLine();

            while (currLine != null) {
                bufferedWriter.write(currLineNum + ". " + currLine + System.lineSeparator());
                currLineNum++;

                currLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}