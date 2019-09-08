import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {

    private final static String URL_HISTORY_BACK = "back";
    private final static String URL_HISTORY_FORWARD = "forward";
    private final static String STR_TO_END_INPUT = "Home";

    private final static String NO_BACK_URLS_ERR = "no previous URLs";
    private final static String NO_FORWARD_URLS_ERR = "no next URLs";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        URLManager urlManager = new URLManager();

        String currInputURL;
        while (!STR_TO_END_INPUT.equals((currInputURL = scanner.nextLine()))) {
            switch (currInputURL) {
                case URL_HISTORY_BACK:
                    if (urlManager.hasBackURL()) {
                        urlManager.back();
                        System.out.println(urlManager.getCurrentURL());
                    } else {
                        System.out.println(NO_BACK_URLS_ERR);
                    }
                    break;
                case URL_HISTORY_FORWARD:
                    if (urlManager.hasForwardURL()) {
                        urlManager.forward();
                        System.out.println(urlManager.getCurrentURL());
                    } else {
                        System.out.println(NO_FORWARD_URLS_ERR);
                    }
                    break;
                default:
                    urlManager.setCurrentURL(currInputURL);
                    System.out.println(currInputURL);
                    break;
            }
        }
    }
}

class URLManager {

    private static String STR_BACK_CMD = "back";
    private static String STR_FORWARD_CMD = "forward";

    private ArrayDeque<String> urlHistoryBack = new ArrayDeque<>();
    private ArrayDeque<String> urlHistoryForward = new ArrayDeque<>();

    private String lastURL;
    private String currentURL;

    private String lastCmd;

    void setCurrentURL(String currentURL) {
        if (this.lastURL != null) {
            urlHistoryBack.addFirst(this.lastURL);
        }

        if (STR_BACK_CMD.equals(this.lastCmd)) {
            this.urlHistoryForward.clear();
        }

        this.currentURL = currentURL;
        this.lastURL = currentURL;
    }

    void back() {
        this.urlHistoryForward.addFirst(this.currentURL);
        this.currentURL = this.urlHistoryBack.removeFirst();
        this.lastCmd = STR_BACK_CMD;
    }

    void forward() {
        this.urlHistoryBack.addFirst(this.currentURL);
        this.currentURL = this.urlHistoryForward.removeFirst();
        this.lastCmd = STR_FORWARD_CMD;
    }

    String getCurrentURL() {
        return this.currentURL;
    }

    boolean hasBackURL() {
        return this.urlHistoryBack.size() > 0;
    }

    boolean hasForwardURL() {
        return this.urlHistoryForward.size() > 0;
    }
}