import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {

    private static final String inputFile = "enterHere";
    private static final String outputFile = "enterHere";

    public static void main(String[] args) {

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputFile))
        ) {
            String currLine = bufferedReader.readLine();
            long currLineASCIISum = 0;

            while (currLine != null) {
                for (char currChar : currLine.toCharArray()) {
                    currLineASCIISum += currChar;
                }
                currLine = bufferedReader.readLine();
            }

            bufferedWriter.write(Long.toString(currLineASCIISum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}