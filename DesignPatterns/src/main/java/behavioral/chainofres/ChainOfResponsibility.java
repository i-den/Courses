package behavioral.chainofres;

import behavioral.chainofres.validator.BeginsWithValidator;
import behavioral.chainofres.validator.ContainsValidator;
import behavioral.chainofres.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibility {
    Validator first;

    ChainOfResponsibility() {
        makeChain();
    }

    public boolean validateName(String name) {
        return first.validate(name);
    }

    void makeChain() {
        List<String> shouldNotBeginWithAny = new ArrayList<>(3);
        shouldNotBeginWithAny.add("/home");
        shouldNotBeginWithAny.add("/home2");
        shouldNotBeginWithAny.add("/home3");
        Validator first = new BeginsWithValidator(shouldNotBeginWithAny);

        List<String> shouldNotContainAny = new ArrayList<>(3);
        shouldNotContainAny.add("backup");
        shouldNotContainAny.add("hacked");
        shouldNotContainAny.add("str");
        Validator second = new ContainsValidator(shouldNotContainAny);

        first.setNext(second);
        this.first = first;
    }
}
