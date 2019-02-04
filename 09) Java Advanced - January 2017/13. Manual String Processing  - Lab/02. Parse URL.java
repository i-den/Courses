import java.util.Scanner;

public class ParseURL {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        URL inputURL = new URL(scanner.nextLine());
        System.out.println(inputURL.printStats());
    }
}

class URL {
    private String rawURL;
    private String protocol;
    private String host;
    private String request;

    URL(String rawURL) {
        this.setRawURL(rawURL);
    }

    private boolean isInvalid() {
        return this.rawURL.matches(".*(://).*(://).*");
    }

    String printStats() {
        if (this.isInvalid()) {
            return "Invalid URL";
        }

        int startIndex = this.rawURL.indexOf("://");
        int endIndex = this.rawURL.indexOf("/", startIndex + 3);

        this.setProtocol(this.rawURL.substring(
                0,
                startIndex
        ));

        this.setHost(this.rawURL.substring(
                startIndex + 3,
                endIndex
        ));

        this.setRequest(this.rawURL.substring(
                endIndex + 1
        ));

        return String.format(
                "Protocol = %s%nServer = %s%nResources = %s%n",
                this.getProtocol(),
                this.getHost(),
                this.getRequest()
        );
    }

    private void setRawURL(String rawURL) {
        this.rawURL = rawURL;
    }

    public String getRawURL() {
        return rawURL;
    }

    private String getProtocol() {
        return protocol;
    }

    private void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    private String getHost() {
        return host;
    }

    private void setHost(String host) {
        this.host = host;
    }

    private String getRequest() {
        return request;
    }

    private void setRequest(String request) {
        this.request = request;
    }
}