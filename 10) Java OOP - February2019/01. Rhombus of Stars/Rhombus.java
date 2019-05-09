import java.util.Arrays;
import java.util.stream.Collectors;

class Rhombus {

    private static final String DRAWING_SYMBOL = "*";

    private static final String WHITESPACE_SYMBOL = " ";

    private int quantifier;

    public Rhombus(int quantifier) {
        this.quantifier = quantifier;
    }

    public void draw() {
        drawTop();
        drawBottom();
    }

    private void drawTop() {
        for (int i = 1; i <= quantifier; i++) {
            String surrWhiteSpace = repeatStr(WHITESPACE_SYMBOL, quantifier - i);
            String drawnSymbols = createDrawnSymbols(DRAWING_SYMBOL, i);
            System.out.println(surrWhiteSpace + drawnSymbols + surrWhiteSpace);
        }
    }

    private void drawBottom() {
        for (int i = quantifier - 1; i > 0 ; i--) {
            String surrWhiteSpace = repeatStr(WHITESPACE_SYMBOL, quantifier - i);
            String drawnSymbols = createDrawnSymbols(DRAWING_SYMBOL, i);
            System.out.println(surrWhiteSpace + drawnSymbols + surrWhiteSpace);
        }
    }

    private String repeatStr(String str, int cnt) {
        return new String(new char[cnt]).replace("\0", str);
    }

    private String createDrawnSymbols(String str, int cnt) {
        return Arrays.stream(new String[cnt])
                .map(s -> str)
                .collect(Collectors.joining(WHITESPACE_SYMBOL));
    }
}
