import java.io.File;

public class ListFiles {

    private static final String rootDirectory = "enterHere";

    public static void main(String[] args) {
        File rootDirFile = new File(rootDirectory);

        if (rootDirFile.isDirectory()) {
            File[] files = rootDirFile.listFiles();

            for (File currFile : files) {
                if (currFile.isFile()) {
                    System.out.printf("%s: [%s]%n", currFile.getName(), currFile.length());
                }
            }
        }
    }
}