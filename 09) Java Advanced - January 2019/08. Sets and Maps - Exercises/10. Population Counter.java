import java.util.HashMap;
import java.util.Scanner;

public class PopulationCounter {

    private static final String STR_TO_END_INPUT = "report";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Long> countryTotalPopulation = new HashMap<>();
        HashMap<String, HashMap<String, Long>>
                countryCitiesPopulation = new HashMap<>();

        String input;
        while (!STR_TO_END_INPUT.equals((input = scanner.nextLine()))) {
            String[] cityCountryPopulationTokens = input.split("\\|");
            Long populationToAdd = Long.parseLong(cityCountryPopulationTokens[2]);

            // Total Population
            countryTotalPopulation.putIfAbsent(cityCountryPopulationTokens[1], 0L);
            countryTotalPopulation.put(
                    cityCountryPopulationTokens[1], // Country
                    countryTotalPopulation.get(cityCountryPopulationTokens[1]) + populationToAdd
            );

            countryCitiesPopulation.putIfAbsent(cityCountryPopulationTokens[1], new HashMap<>());
            HashMap<String, Long> citiesPopulation = countryCitiesPopulation.get(cityCountryPopulationTokens[1]);
            citiesPopulation.putIfAbsent(cityCountryPopulationTokens[0], 0L);
            citiesPopulation.put(
                    cityCountryPopulationTokens[0], // City
                    citiesPopulation.get(cityCountryPopulationTokens[0]) + populationToAdd
            );
        }

        countryCitiesPopulation.keySet().stream()
                .sorted((c1, c2) -> countryTotalPopulation.get(c2).compareTo(countryTotalPopulation.get(c1)))
                .forEach(countryName -> {
                    System.out.printf(
                            "%s (total population: %d)%s",
                            countryName,
                            countryTotalPopulation.get(countryName),
                            System.lineSeparator()
                    );

                    HashMap<String, Long> citiesPopulation = countryCitiesPopulation.get(countryName);
                    citiesPopulation.keySet().stream()
                            .sorted((c1, c2) -> citiesPopulation.get(c2).compareTo(citiesPopulation.get(c1)))
                            .forEach(cityName -> System.out.printf(
                                    "=>%s: %d%s",
                                    cityName,
                                    citiesPopulation.get(cityName),
                                    System.lineSeparator()
                            ));
                });
    }
}