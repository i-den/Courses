package Controllers;

import Car.Car;
import Company.CompanyInfo;
import Person.*;
import Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputController {

    private static final String STR_TO_END_INPUT = "End";

    private static final String CMD_CREATE_COMPANY_INFO = "company";
    private static final String CMD_CREATE_POKEMON = "pokemon";
    private static final String CMD_CREATE_PARENT = "parents";
    private static final String CMD_CREATE_CHILD = "children";
    private static final String CMD_CREATE_CAR = "car";

    private List<Person> people;

    private Scanner scanner;

    public InputController() {
        people = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void getPeopleFromInput() {
        String personInfo;
        while (!(personInfo = scanner.nextLine()).equals(STR_TO_END_INPUT)) {
            String[] personTokens = personInfo.split("\\s+");

            Person person = findPersonByName(personTokens[0]);
            if (person == null) {
                person = new Person(personTokens[0]);
                people.add(person);
            }

            // WTB DI
            switch (personTokens[1]) {
                case CMD_CREATE_COMPANY_INFO:
                    person.setCompanyInfo(new CompanyInfo(
                            personTokens[2],
                            personTokens[3],
                            Double.parseDouble(personTokens[4])
                    ));
                    break;
                case CMD_CREATE_POKEMON:
                    person.addPokemon(new Pokemon(
                            personTokens[2],
                            personTokens[3]
                    ));
                    break;
                case CMD_CREATE_PARENT:
                    person.addParent(new Parent(
                            personTokens[2],
                            personTokens[3]
                    ));
                    break;
                case CMD_CREATE_CHILD:
                    person.addChild(new Child(
                            personTokens[2],
                            personTokens[3]
                    ));
                    break;
                case CMD_CREATE_CAR:
                default:
                    person.setCar(new Car(
                            personTokens[2],
                            Integer.parseInt(personTokens[3])
                    ));
                    break;
            }
        }
    }

    private Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public void printPerson() {
        String personNameToFind = scanner.nextLine();
        Person person = findPersonByName(personNameToFind);
        System.out.println(person);
    }
}
