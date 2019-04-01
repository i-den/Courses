import java.io.*;

public class AllCapitals {

    private static final String INPUT_FILE = "enterHere";
    private static final String OUTPUT_FILE = "enterHere";

    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}