import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter {

    private static String strToEndInput = "report";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Long> countryTotalPopul = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> countryAndCities = new LinkedHashMap<>();

        while (true) {
            String[] currInput = scanner.nextLine()
                    .split("\\|");

            if (strToEndInput.equals(currInput[0])) {
                break;
            }

            String currCity = currInput[0];
            String currCountry = currInput[1];
            Long currCityPopul = Long.parseLong(currInput[2]);

            if (!countryTotalPopul.containsKey(currCountry)) {
                countryTotalPopul.put(currCountry, 0L);
            }
            countryTotalPopul.put(currCountry, countryTotalPopul.get(currCountry) + currCityPopul);

            if (!countryAndCities.containsKey(currCountry)) {
                countryAndCities.put(currCountry, new LinkedHashMap<>());
            }

            LinkedHashMap<String, Long> currCityMap = countryAndCities.get(currCountry);
            currCityMap.put(currCity, currCityPopul);
        }

        countryAndCities.entrySet()
                .stream()
                .sorted((firstCountry, secCountry) -> countryTotalPopul.get(secCountry.getKey()).compareTo(countryTotalPopul.get(firstCountry.getKey())))
                .forEach(currCountryCities -> {
                    System.out.printf("%s (total population: %d)%n", currCountryCities.getKey(), countryTotalPopul.get(currCountryCities.getKey()));

                    currCountryCities.getValue()
                            .entrySet()
                            .stream()
                            .sorted((firstCity, secCity) -> secCity.getValue().compareTo(firstCity.getValue()))
                            .forEach(currCity -> {
                                System.out.printf("=>%s: %d%n", currCity.getKey(), currCity.getValue());
                            });
                });
    }
}