import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MergeTwoFiles {

    private static final String firstInputFile = "enterHere";
    private static final String secInputFile = "enterHere";
    private static final String outputFile = "enterHere";
    
    public static void main(String[] args) {
        Path firstInput = Paths.get(firstInputFile);
        Path secInput = Paths.get(secInputFile);
        Path output = Paths.get(outputFile);

        try (
                Stream<String> firstFileLines = Files.lines(firstInput);
                Stream<String> secFileLines = Files.lines(secInput)
        ) {
            StringBuilder stringBuilder = new StringBuilder();

            appendLines(firstFileLines, stringBuilder);
            appendLines(secFileLines, stringBuilder);

            Files.write(output, stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendLines(Stream<String> firstFileLines, StringBuilder stringBuilder) {
        firstFileLines.forEach(currLine -> {
            String currLineToWrite = currLine + System.lineSeparator();
            stringBuilder.append(currLineToWrite);
        });
    }
}