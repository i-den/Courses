import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17_Letter_Combination_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> allCombinations = new ArrayList<>();
        allCombinations.add("");
        Map<Character, Character[]> phoneButtons = initPhoneButtons();
        char[] dialedDigits = digits.toCharArray();

        for (char dialedDigit : dialedDigits) {
            allCombinations = getCombinationsFromNextDigit(allCombinations, phoneButtons.get(dialedDigit));
        }

        return allCombinations;
    }

    private List<String> getCombinationsFromNextDigit(List<String> allCombinations, Character[] dialedDigitCharacters) {
        List<String> combinations = new ArrayList<>();
        for (String oldCombination : allCombinations) {
            for (Character dialedDigitCharacter : dialedDigitCharacters) {
                combinations.add(oldCombination + dialedDigitCharacter);
            }
        }
        return combinations;
    }

    private Map<Character, Character[]> initPhoneButtons() {
        Map<Character, Character[]> phoneButtons = new HashMap<>();
        phoneButtons.put('2', new Character[]{'a', 'b', 'c'});
        phoneButtons.put('3', new Character[]{'d', 'e', 'f'});
        phoneButtons.put('4', new Character[]{'g', 'h', 'i'});
        phoneButtons.put('5', new Character[]{'j', 'k', 'l'});
        phoneButtons.put('6', new Character[]{'m', 'n', 'o'});
        phoneButtons.put('7', new Character[]{'p', 'q', 'r', 's'});
        phoneButtons.put('8', new Character[]{'t', 'u', 'v'});
        phoneButtons.put('9', new Character[]{'w', 'x', 'y', 'z'});
        return phoneButtons;
    }
}
