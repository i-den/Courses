package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S05_String_Rotation {
    private static int ROTATIONS = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String strToRotate = input.readLine();
            String needle = input.readLine();
            System.out.println(needleIsContainedInRotatedWord(strToRotate, needle));
        }
    }

    private static int needleIsContainedInRotatedWord(String strToRotate, String needle) {
        int rotations = ROTATIONS % strToRotate.length();

        String leftRotation = strToRotate.substring(rotations) + strToRotate.substring(0, rotations);
        String rightRotation = strToRotate.substring(strToRotate.length() - rotations) + strToRotate.substring(0, strToRotate.length() - rotations);

        if (leftRotation.equals(needle) || rightRotation.equals(needle))
            return 1;

        return 0;
    }

}
