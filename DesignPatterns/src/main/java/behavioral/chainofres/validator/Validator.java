package behavioral.chainofres.validator;

public abstract class Validator {
    protected Validator next;

    public abstract boolean validate(String name);

    public void setNext(Validator next) {
        this.next = next;
    }
}
