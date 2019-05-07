<h1 align="center"><em>Java Advanced - September 2017</em></h1>
 
<br />

 ## *Java syntax*
>  ### **
 ```Java
import java.math.BigInteger;
import java.util.Scanner;

public class Problem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();

        BigInteger fact = findFactorialInRange(new BigInteger("1"), startNum, endNum);
        System.out.printf("product[%d..%d] = %d", startNum, endNum, fact);
    }

    private static BigInteger findFactorialInRange(BigInteger accumulator, int currNum, int finalNum) {

        if (currNum > finalNum) {
            return accumulator;
        }

        accumulator = accumulator.multiply(BigInteger.valueOf(currNum));

        return findFactorialInRange(accumulator, currNum + 1, finalNum);
    }
}
 ```
> ### *Stacks and Queues / ArrayDequeue*
 ```Java
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> kids = new ArrayDeque<>();

        Collections.addAll(kids, scanner.nextLine().split("\\s+"));
        int hotPotatoCnt = scanner.nextInt();

        while (kids.size() > 1) {
            for (int i = 1; i < hotPotatoCnt; i++) {
                String currentKid = kids.remove();
                kids.add(currentKid);
            }
            System.out.printf("Removed %s%n", kids.pop());
        }

        System.out.printf("Last is %s%n", kids.pop());
    }
}
 ```
> ### *RegEx in Java*
 ```Java
 public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> correctSentences = new LinkedHashSet<>();

        Pattern validSentenceRegEx = Pattern.compile("[A-Z][^.!?]*[.!?]");

        try {
            String needleWord = reader.readLine();
            String haystackText = reader.readLine();

            Pattern validNeedleWordRegEx = Pattern.compile(String.format("%s%s%s", "\\b", needleWord, "\\b"));
            Matcher validSentenceFinder = validSentenceRegEx.matcher(haystackText);

            while (validSentenceFinder.find()) {
                String currValidSentence = validSentenceFinder.group();

                Matcher validWordFinder = validNeedleWordRegEx.matcher(currValidSentence);
                if (validWordFinder.find()) {
                    correctSentences.add(currValidSentence);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String correctSentence : correctSentences) {
            System.out.println(correctSentence);
        }
}
 ```
> ### *Stream API Introduction*
 ```Java
 public static void main(String[] args) {
        OptionalDouble numExists = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .filter(str -> !str.isEmpty())
                .mapToDouble(Double::parseDouble)
                .filter(num -> num % 2 == 0)
                .min();

        System.out.println(
                numExists.isPresent()
                        ? String.format("%1$.2f", numExists.getAsDouble())
                        : "No match"
        );
    }
 ```
<p align="center">
<a href="https://softuni.bg/trainings/1531/java-advanced-january-2017">Course Page</a> <br />
<p>
