import java.util.Scanner;

public class Main {
    final static int minColWidth = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        double secNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();

        String[] strCols = {
                formatColumn(Integer.toHexString(firstNum), " ", true).toUpperCase(),
                formatColumn(Integer.toBinaryString(firstNum), "0", false),
                formatColumn(String.format("%.2f", secNum), " ", false),
                formatColumn(String.format("%.3f", thirdNum), " ", true)
        };

        System.out.printf("|%s|", String.join("|", strCols));
    }

    private static String formatColumn(String strToPrint, String fillerStr, boolean padRight) {
        if (padRight) {
            return (strToPrint + strRepeat(fillerStr, minColWidth)).substring(0, minColWidth);
        }

        String strToReturn = (strRepeat(fillerStr, minColWidth) + strToPrint);
        return strToReturn.substring(strToReturn.length() - 10);
    }

    private static String strRepeat(String str, int repeatCnt) {
        return new String(new char[repeatCnt]).replace("\0", str);
    }
}