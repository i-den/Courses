import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartyReservationFilterModule {

    private static final String strToEndInput = "Print";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            CommandManager commandManager= new CommandManager();
            PartyManager partyManager = new PartyManager();
            List<String> partyPeople = Arrays.stream(reader.readLine().split("\\s+"))
                    .collect(Collectors.toList());

            String currCommand;
            while (!strToEndInput.equals((currCommand = reader.readLine()))) {
                commandManager.accumulateCommand(currCommand);
            }

            partyPeople = partyManager.filterList(partyPeople, commandManager);

            System.out.println(String.join(" ", partyPeople));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PartyManager {

    List<String> filterList(List<String> listToFilter, CommandManager commandManager) {
        List<String> filteredNames = new LinkedList<>();
        for (String currName : listToFilter) {
            if (!nameMatchesAnyFilter(currName, commandManager.getExistingFilters())) {
                filteredNames.add(currName);
            }
        }
        return filteredNames;
    }

    private boolean nameMatchesAnyFilter(String currName, List<PartyFilter> existingFilters) {
        for (PartyFilter currFilter : existingFilters) {
            if (currFilter.test(currName)) {
                return true;
            }
        }
        return false;
    }
}

class PartyFilter {
    private static final String strFilterOptStartsWith = "StartsWith";
    private static final String strFilterOptEndsWith = "EndsWith";
    private static final String strFilterOptLen = "Length";
    private static final String strContainsOpt = "Contains";

    private Predicate<String> filterStartsWithFn = name -> name.startsWith(this.getSpecifier());
    private Predicate<String> filterEndsWithFn = name -> name.endsWith(this.getSpecifier());
    private Predicate<String> filterNameByLenFn = name -> name.length() == Integer.parseInt(this.getSpecifier());
    private Predicate<String> filterNameByContains = name -> name.contains(this.getSpecifier());

    private String filterOption;
    private String specifier;

    PartyFilter(String filterOption, String specifier) {
        this.setFilterOption(filterOption);
        this.setSpecifier(specifier);
    }

    Boolean test(String name) {
        Predicate<String> filterFn;
        switch (this.getFilterOption()) {
            case strFilterOptStartsWith:
                filterFn = filterStartsWithFn;
                break;
            case strFilterOptEndsWith:
                filterFn = filterEndsWithFn;
                break;
            case strFilterOptLen:
                filterFn = filterNameByLenFn;
                break;
            default:
                filterFn = filterNameByContains;
                break;
        }
        return filterFn.test(name);
    }

    String getFilterOption() {
        return filterOption;
    }

    private void setFilterOption(String filterOption) {
        this.filterOption = filterOption;
    }

    String getSpecifier() {
        return specifier;
    }

    private void setSpecifier(String specifier) {
        this.specifier = specifier;
    }
}

class CommandManager {
    private static final String strToAddFilter = "Add filter";
    private static final String strToRemoveFilter = "Remove filter";

    private List<PartyFilter> existingFilters = new LinkedList<>();

    void accumulateCommand(String command) {
        String[] cmdTokens = command.split(";");

        switch (cmdTokens[0]) {
            case strToAddFilter:
                existingFilters.add(new PartyFilter(cmdTokens[1], cmdTokens[2]));
                break;
            default:
                System.out.println();
                existingFilters.removeIf(filter ->
                        filter.getFilterOption().equals(cmdTokens[1])
                     && filter.getSpecifier().equals(cmdTokens[2])
                );
                break;
        }
    }

    List<PartyFilter> getExistingFilters() {
        return this.existingFilters;
    }
}