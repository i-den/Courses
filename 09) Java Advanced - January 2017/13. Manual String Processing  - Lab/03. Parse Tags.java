import java.util.Scanner;

public class ParseTags {

    private static final String upcaseOpenTag = "<upcase>";
    private static final String upcaseCloseTag = "</upcase>";
    private static final int upcaseLength = upcaseOpenTag.length();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String txtToFormat = scanner.nextLine();

        while (txtToFormat.contains(upcaseOpenTag)) {
            int startingIndex = txtToFormat.indexOf(upcaseOpenTag);
            int endingIndex = txtToFormat.indexOf(upcaseCloseTag);

            String currTextToReplace = txtToFormat.substring(startingIndex + upcaseLength, endingIndex);
            txtToFormat = txtToFormat.replace(
                    upcaseOpenTag + currTextToReplace + upcaseCloseTag,
                    currTextToReplace.toUpperCase()
            );
        }

        System.out.println(txtToFormat);
    }
}