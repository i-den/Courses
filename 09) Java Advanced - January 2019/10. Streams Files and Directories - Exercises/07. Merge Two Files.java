import java.io.*;

public class MergeTwoFiles {

    private static final String FIRST_FILE = "enterHere";
    private static final String SECOND_FILE = "enterHere";
    private static final String OUTPUT_FILE = "enterHere";

    public static void main(String[] args) {
        try (
                BufferedReader firstFileReader = new BufferedReader(new FileReader(FIRST_FILE));
                BufferedReader secondFileReader = new BufferedReader(new FileReader(SECOND_FILE));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE))
        ) {
            String line;
            while ((line = firstFileReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());
            }
            while ((line = secondFileReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}