package behavioral.chainofres.validator;

import java.util.List;

public class BeginsWithValidator extends Validator {
    List<String> forbiddenBeginsWithWords;

    public BeginsWithValidator(List<String> forbiddenBeginsWithWords) {
        this.forbiddenBeginsWithWords = forbiddenBeginsWithWords;
    }

    @Override
    boolean validate(String name) {
        for (String forbiddenBeginsWithWord : forbiddenBeginsWithWords) {
            if (name.startsWith(forbiddenBeginsWithWord))
                return false;
        }
        if (next != null)
            return next.validate(name);
        return false;
    }
}
