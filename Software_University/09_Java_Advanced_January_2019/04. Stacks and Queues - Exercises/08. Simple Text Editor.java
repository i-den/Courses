import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

    private static final String APPEND_CMD = "1";
    private static final String ERASE_CMD = "2";
    private static final String RETURN_CHAR_CMD = "3";
    private static final String UNDO_LAST_CMD = "4";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputManager inputManager = new InputManager();

        int cmdCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cmdCnt; i++) {
            String[] cmdTokens = scanner.nextLine().split("\\s+");

            switch (cmdTokens[0]) {
                case APPEND_CMD:
                    inputManager.appendText(cmdTokens[1]);
                    break;
                case ERASE_CMD:
                    inputManager.eraseText(Integer.parseInt(cmdTokens[1]));
                    break;
                case RETURN_CHAR_CMD:
                    inputManager.printCharAt(Integer.parseInt(cmdTokens[1]) - 1);
                    break;
                case UNDO_LAST_CMD:
                default:
                    inputManager.undoLastCmd();
                    break;
            }
        }
    }
}

class InputManager {
    private ArrayDeque<String> inputHistory;
    private StringBuilder currentText;

    InputManager() {
        this.inputHistory = new ArrayDeque<>();
        this.currentText = new StringBuilder();
    }

    void appendText(String textToAppend) {
        updateHistory();
        this.currentText.append(textToAppend);
    }

    void eraseText(int eraseLastCharsCnt) {
        updateHistory();
        this.currentText.setLength(currentText.length() - eraseLastCharsCnt);
    }

    void printCharAt(int charIndex) {
        System.out.println(this.currentText.charAt(charIndex));
    }

    private void updateHistory() {
        this.inputHistory.addFirst(currentText.toString());
    }

    void undoLastCmd() {
        this.currentText = new StringBuilder(this.inputHistory.removeFirst());
    }
}