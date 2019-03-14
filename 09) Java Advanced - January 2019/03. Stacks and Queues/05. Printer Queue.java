import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {

    private static final String CANCEL_PRINT_CMD = "cancel";
    private static final String SUCCESSFUL_CANCEL_CMD = "Canceled";
    private static final String EMPTY_PRINT_QUEUE = "Printer is on standby";
    private static final String PRINT_CMD = "print";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String currPrinterCmd;
        while (!PRINT_CMD.equals((currPrinterCmd = scanner.nextLine()))) {
            if (CANCEL_PRINT_CMD.equals(currPrinterCmd)) {
                if (printerQueue.isEmpty()) {
                    System.out.println(EMPTY_PRINT_QUEUE);
                } else {
                    String currDocToCancel = printerQueue.pollFirst();
                    System.out.println(String.format("%s %s", SUCCESSFUL_CANCEL_CMD, currDocToCancel));
                }
            } else {
                printerQueue.addLast(currPrinterCmd);
            }
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.removeFirst());
        }
    }
}