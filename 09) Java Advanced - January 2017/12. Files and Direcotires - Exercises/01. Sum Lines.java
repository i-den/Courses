import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {

    private static final String inputFile = "enterHere";
    private static final String outputFile = "enterHere";

    public static void main(String[] args) {

        try (
                BufferedReader buffRead = Files.newBufferedReader(Paths.get(inputFile)) ;
                FileOutputStream fileOutStr = new FileOutputStream(outputFile)
        ) {
            String currLine = buffRead.readLine();

            while (currLine != null) {
                int currLineSum = 0;
                for (char currChar : currLine.toCharArray()) {
                    currLineSum += currChar;
                }

                String currIntVal = Integer.toString(currLineSum);
                for (int i = 0; i < currIntVal.length(); i++) {
                    fileOutStr.write(currIntVal.charAt(i));
                }
                fileOutStr.write('\n');

                currLine = buffRead.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}