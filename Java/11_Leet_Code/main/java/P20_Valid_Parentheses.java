import java.util.ArrayDeque;

public class P20_Valid_Parentheses {

    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char c = s.charAt(i);
            if  (c == '('
                    || c =='{'
                    || c == '[') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty())
                    return false;

                char lastBracket = stack.removeLast();
                if (lastBracket == '(' && c != ')')
                    return false;

                if (lastBracket == '{' && c != '}')
                    return false;

                if  (lastBracket == '[' && c != ']')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
