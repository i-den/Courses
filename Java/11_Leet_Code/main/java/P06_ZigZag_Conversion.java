import java.util.ArrayList;
import java.util.List;

public class P06_ZigZag_Conversion {

    public String convert(String string, int numRows) {
        if (numRows == 1)
            return string;

        List<StringBuilder> rows = new ArrayList<>(string.length());
        int maxRowsThatWillExist = Math.min(string.length(), numRows);
        for (int i = 0; i < maxRowsThatWillExist; i++) {
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        boolean goingDown = false;
        for (char c : string.toCharArray()) {
            rows.get(currRow).append(c);
            if (currRow == 0 || currRow == numRows - 1) goingDown = !goingDown;
            currRow += goingDown ? 1 : -1;
        }

        StringBuilder zigZagWord = new StringBuilder();
        for (StringBuilder row : rows) {
            zigZagWord.append(row);
        }
        return zigZagWord.toString();
    }
}
