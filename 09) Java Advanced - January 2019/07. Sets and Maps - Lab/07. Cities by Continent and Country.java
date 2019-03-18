import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class CitiesByContinentAndCountry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, LinkedList<String>>>
                continentsCountriesCities = new LinkedHashMap<>();

        int inputCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < inputCnt; i++) {
            String[] continentCountryCityTokens = scanner.nextLine().split("\\s+");

            // Continent
            continentsCountriesCities.putIfAbsent(continentCountryCityTokens[0], new LinkedHashMap<>());

            // Country
            LinkedHashMap<String, LinkedList<String>>
                    countryCities = continentsCountriesCities.get(continentCountryCityTokens[0]);
            countryCities.putIfAbsent(continentCountryCityTokens[1], new LinkedList<>());

            // Cities
            LinkedList<String> cities = countryCities.get(continentCountryCityTokens[1]);
            cities.add(continentCountryCityTokens[2]);
        }

        for (String continent : continentsCountriesCities.keySet()) {
            LinkedHashMap<String, LinkedList<String>>
                    countryCities = continentsCountriesCities.get(continent);

            System.out.printf("%s:%s", continent, System.lineSeparator());
            for (String country : countryCities.keySet()) {
                System.out.printf(
                        "%s -> %s%s",
                        country,
                        String.join(", ", countryCities.get(country)),
                        System.lineSeparator()
                );
            }
        }
    }
}