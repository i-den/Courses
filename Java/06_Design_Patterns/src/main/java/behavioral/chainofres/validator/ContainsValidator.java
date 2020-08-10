package behavioral.chainofres.validator;

import java.util.List;

public class ContainsValidator extends Validator {
    List<String> forbiddenContainsWords;

    public ContainsValidator(List<String> forbiddenContainsWords) {
        this.forbiddenContainsWords = forbiddenContainsWords;
    }

    @Override
    boolean validate(String name) {
        for (String forbiddenContainsWord : forbiddenContainsWords) {
            if (name.contains(forbiddenContainsWord))
                return false;
        }
        if (next != null)
            return next.validate(name);
        return true;
    }
}
