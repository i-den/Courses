import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {

    private static final String inputFile = "enterHere";
    private static final String outputFile = "enterHere";

    public static void main(String[] args) {
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        try {
            List<String> inputFileLines = Files.readAllLines(inputPath);
            Collections.sort(inputFileLines);
            Files.write(outputPath, inputFileLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}