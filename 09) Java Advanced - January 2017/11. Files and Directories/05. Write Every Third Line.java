import java.io.*;

public class WriteEveryThirdLine {

    private static final String inputFile = "enterHere";

    public static void main(String[] args) {

        try (BufferedReader buffReader = new BufferedReader(new FileReader(inputFile))) {
            String currLine = buffReader.readLine();
            int currLineCnt = 1;

            while (currLine != null) {
                if (currLineCnt % 3 == 0) {
                    System.out.println(currLine);
                }

                currLineCnt++;
                currLine = buffReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}