import java.util.*;

public class MapDistricts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<City> cities = new ArrayList<>();

        String inpCitiesInfo = scanner.nextLine();
        int minCityPopulation = Integer.parseInt(scanner.nextLine());

        for (String currCityTokens : inpCitiesInfo.split("\\s+")) {
            String[] cityNameAndPopulationToAdd = currCityTokens.split(":");
            City currCity = City.findCityByName(cityNameAndPopulationToAdd[0], cities);

            if (currCity != null) {
                currCity.addPopulation(Integer.parseInt(cityNameAndPopulationToAdd[1]));
            } else {
                cities.add(
                        new City(cityNameAndPopulationToAdd[0], Integer.parseInt(cityNameAndPopulationToAdd[1]))
                );
            }
        }

        cities.stream()
                .filter(e -> e.getTotalPopulation() > minCityPopulation)
                .sorted((a, b) -> b.getTotalPopulation().compareTo(a.getTotalPopulation()))
                .forEach(City::printPopulation);
    }
}

class City {

    private String districtName;

    private List<Integer> populationPerInput = new LinkedList<>();

    City(String districtName, Integer currPopulationToAdd) {
        this.setDistrictName(districtName);
        this.getPopulationPerInput().add(currPopulationToAdd);
    }

    public Integer getTotalPopulation() {
        return this.getPopulationPerInput().stream().mapToInt(Integer::valueOf).sum();
    }

    public void printPopulation() {
        System.out.print(this.getDistrictName() + ": ");
        this.getPopulationPerInput().stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public void addPopulation(Integer populationToAdd) {
        this.getPopulationPerInput().add(populationToAdd);
    }

    public static City findCityByName(String districtName, List<City> cities) {
        for (City currCity : cities) {
            if (districtName.equals(currCity.getDistrictName())) {
                return currCity;
            }
        }
        return null;
    }

    public String getDistrictName() {
        return districtName;
    }

    private void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public List<Integer> getPopulationPerInput() {
        return populationPerInput;
    }

    public void setPopulationPerInput(List<Integer> populationPerInput) {
        this.populationPerInput = populationPerInput;
    }
}