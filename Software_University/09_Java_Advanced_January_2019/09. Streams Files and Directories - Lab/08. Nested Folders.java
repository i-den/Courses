import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {

    private static final String INPUT_DIRECTORY = "enterHere";

    public static void main(String[] args) {
        File folderToListContent = new File(INPUT_DIRECTORY);
        ArrayDeque<File> files = new ArrayDeque<>();

        files.addFirst(folderToListContent);
        int folderCnt = 1;

        while (!files.isEmpty()) {
            File currFile = files.removeFirst();
            System.out.println(currFile.getName());
            for (File file : currFile.listFiles()) {
                if (file.isDirectory()) {
                    files.addLast(file);
                    folderCnt++;
                }
            }
        }
        System.out.println(folderCnt);
    }
}