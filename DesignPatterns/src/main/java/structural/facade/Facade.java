package structural.facade;

public class Facade {
    Library library;

    public void partyHard() {
        library.doSomething();
    }

    public void connecting() {
        // not using library
    }
}
