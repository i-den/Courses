import java.io.File;
import java.util.ArrayDeque;

public class ListFiles {

    private static final String rootDirectory = "enterHere";

    public static void main(String[] args) {
        File rootDirFile = new File(rootDirectory);
        ArrayDeque<File> files = new ArrayDeque<>();
        int fileCnt = 1;

        files.offer(rootDirFile);
        System.out.println(rootDirFile.getName());

        while (!files.isEmpty()) {
            File currFile = files.pollLast();

            for (File file : currFile.listFiles()) {
                if (file.isDirectory()) {
                    System.out.println(file.getName());
                    files.push(file);
                    fileCnt++;
                }
            }
        }

        System.out.printf("%d folders%n", fileCnt);
    }
}