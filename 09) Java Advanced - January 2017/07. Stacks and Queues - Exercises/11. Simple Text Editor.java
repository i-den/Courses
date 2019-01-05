import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> changedText = new ArrayDeque<>();

        StringBuilder text = new StringBuilder();
        String lastStrToAdd = "";

        int cmdCnt = scanner.nextInt();

        for (int i = 0; i < cmdCnt; i++) {
            int cmd = scanner.nextInt();

            switch (cmd) {
                case 1:
                    text.append(scanner.next());
                    changedText.push(lastStrToAdd);
                    lastStrToAdd = text.toString();
                    break;
                case 2:
                    int charsToRemove = scanner.nextInt();
                    text.reverse();
                    text.delete(0, charsToRemove);
                    text.reverse();
                    changedText.push(lastStrToAdd);
                    lastStrToAdd = text.toString();
                    break;
                case 3:
                    int index = scanner.nextInt();
                    System.out.println(text.charAt(index - 1));
                    break;
                case 4:
                    text = new StringBuilder(changedText.pop());
                    break;
            }
        }


    }
}