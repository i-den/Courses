import java.io.File;

public class GetFolderSize {

    private static final String DIR_TO_LIST = "enterHere";

    public static void main(String[] args) {
        File folderToListSize = new File(DIR_TO_LIST);
        long totalSize = 0L;

        for (File file : folderToListSize.listFiles()) {
            totalSize += file.length();
        }

        System.out.println(totalSize);
    }
}