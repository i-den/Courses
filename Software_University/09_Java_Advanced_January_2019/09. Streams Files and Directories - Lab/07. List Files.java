import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {

    private static final String INPUT_DIRECTORY = "enterHere";

    public static void main(String[] args) {
        File folderToListContent = new File(INPUT_DIRECTORY);
        File[] allFiles = folderToListContent.listFiles();

        for (File file : allFiles) {
            if (!file.isDirectory()) {
                System.out.printf(
                        "%s : [%d]%s",
                        file.getName(),
                        file.getTotalSpace(),
                        System.lineSeparator()
                );
            }
        }
    }
}