import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    private static final String strToEndInput = "Party!";
    private static final String strToPrintNobody = "Nobody is going to the party!";
    private static final String strToPrintForParty = "are going to the party!";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            List<String> partyPeople = Arrays.stream(reader.readLine().split("\\s+"))
                    .collect(Collectors.toList());

            String[] inputCmdTokens = reader.readLine().split("\\s+");
            while (!strToEndInput.equals(inputCmdTokens[0])) {
                PartyManager partyManager = new PartyManager(inputCmdTokens[0]);
                PartyFilter partyFilter = new PartyFilter(inputCmdTokens[1], inputCmdTokens[2]);

                partyPeople = partyManager.filterList(partyPeople, partyFilter);

                inputCmdTokens = reader.readLine().split("\\s+");
            }

            if (partyPeople.isEmpty()) {
                System.out.println(strToPrintNobody);
            } else {
                System.out.println(
                        String.format(
                                "%s %s",
                                String.join(", ", partyPeople),
                                strToPrintForParty
                        )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PartyFilter {
    private static final String strFilterOptStartsWith = "StartsWith";
    private static final String strFilterOptEndsWith = "EndsWith";
    private static final String strFilterOptLen = "Length";

    private Predicate<String> filterStartsWithFn = name -> name.startsWith(this.getSpecifier());
    private Predicate<String> filterEndsWithFn = name -> name.endsWith(this.getSpecifier());
    private Predicate<String> filterNameByLenFn = name -> name.length() == Integer.parseInt(this.getSpecifier());

    private String filterOption;
    private String specifier;

    PartyFilter(String filterOption, String specifier) {
        this.setFilterOption(filterOption);
        this.setSpecifier(specifier);
    }

    Boolean filter(String name) {
        Predicate<String> filterFn;
        switch (this.getFilterOption()) {
            case strFilterOptStartsWith:
                filterFn = filterStartsWithFn;
                break;
            case strFilterOptEndsWith:
                filterFn = filterEndsWithFn;
                break;
            default:
                filterFn = filterNameByLenFn;
                break;
        }
        return filterFn.test(name);
    }

    private String getFilterOption() {
        return filterOption;
    }

    private void setFilterOption(String filterOption) {
        this.filterOption = filterOption;
    }

    private String getSpecifier() {
        return specifier;
    }

    private void setSpecifier(String specifier) {
        this.specifier = specifier;
    }
}

class PartyManager {
    private static final String strToDouble = "Double";
    private static final String strToRemove = "Remove";

    private String command;

    PartyManager(String command) {
        this.setCommand(command);
    }

    List<String> filterList(List<String> listToFilter, PartyFilter partyFilter) {
        List<String> listToReturn = new LinkedList<>();
        switch (this.getCommand()) {
            case strToDouble:
                for (String currName : listToFilter) {
                    listToReturn.add(currName);
                    if (partyFilter.filter(currName)) {
                        listToReturn.add(currName);
                    }
                }
                break;
            default:
                    listToReturn = listToFilter.stream()
                            .filter(currName -> !partyFilter.filter(currName))
                            .collect(Collectors.toCollection(LinkedList::new));
                break;
        }
        return listToReturn;
    }

    private String getCommand() {
        return command;
    }

    private void setCommand(String command) {
        this.command = command;
    }
}