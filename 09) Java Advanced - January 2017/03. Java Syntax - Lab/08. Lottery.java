public class Main {
    public static void main(String[] args) {
        int firstNum = 1;
        int secNum = 2;
        int thirdNum = 3;

        String strToPrint = getLottery(firstNum, secNum, thirdNum, "");
        System.out.println(strToPrint);
    }

    private static String getLottery(int firstNum, int secNum, int thirdNum, String strToPrint) {

        strToPrint += String.format("%d %d %d%n", firstNum, secNum, thirdNum);

        if (firstNum == 8) {
            return strToPrint;
        }

        if (secNum == 9) {
            return getLottery(firstNum + 1, firstNum + 2, firstNum + 3, strToPrint);
        }

        if (thirdNum == 10) {
            return getLottery(firstNum, secNum + 1, secNum + 2, strToPrint);
        }

        return getLottery(firstNum, secNum, thirdNum + 1, strToPrint);
    }
}