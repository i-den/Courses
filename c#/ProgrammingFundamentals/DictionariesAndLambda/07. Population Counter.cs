using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var countryCityPopulationList = new Dictionary<string, Dictionary<string, long>>();
        var canContinue = true;

        while (canContinue)
        {
            var input = Console.ReadLine().Split('|');

            if (input[0].ToLower() == "report")
            {
                canContinue = false;
                break;
            }

            var currentCountry = input[1];
            var currentCity = input[0];
            var currentPopulation = int.Parse(input[2]);

            if (!countryCityPopulationList.ContainsKey(currentCountry))
            {
                countryCityPopulationList[currentCountry] = new Dictionary<string, long>();
            }

            if (!countryCityPopulationList[currentCountry].ContainsKey(currentCity))
            {
                countryCityPopulationList[currentCountry][currentCity] = 0;
            }

            countryCityPopulationList[currentCountry][currentCity] += currentPopulation;
        }

        var countryTotalPopulationList = new Dictionary<string, long>();

        foreach (var countryPopulationPair in countryCityPopulationList)
        {
            var currCountryName = countryPopulationPair.Key;
            var totalCountryPopulation = countryPopulationPair.Value.Values.Sum();

            countryTotalPopulationList[currCountryName] = totalCountryPopulation;
        }

        foreach (var countryCityPopulationPair in countryTotalPopulationList.OrderByDescending(x => x.Value))
        {
            var currentCountryName = countryCityPopulationPair.Key;
            var totalCountryPopulation = countryCityPopulationPair.Value;

            Console.WriteLine($"{currentCountryName} (total population: {totalCountryPopulation})");

            foreach (var cityPopulationPair in countryCityPopulationList[currentCountryName].OrderByDescending(x => x.Value))
            {
                var currentCityName = cityPopulationPair.Key;
                var currentCityPopulation = cityPopulationPair.Value;

                Console.WriteLine($"=>{currentCityName}: {currentCityPopulation}");
            }
        }
    }
}