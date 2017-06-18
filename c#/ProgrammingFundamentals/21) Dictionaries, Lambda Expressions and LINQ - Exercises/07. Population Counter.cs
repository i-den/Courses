using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var countryCityPopulation = new Dictionary<string, Dictionary<string, long>>();
        var countryPopulation = new Dictionary<string, long>();

        while (true)
        {
            var input = Console.ReadLine();

            if (input == "report")
            {
                break;
            }

            var inputTokens = input.Split('|');
            var currCountry = inputTokens[1];
            var currCity = inputTokens[0];
            var currCount = long.Parse(inputTokens[2]);

            if (!countryCityPopulation.ContainsKey(currCountry))
            {
                countryCityPopulation[currCountry] = new Dictionary<string, long>();
            }

            AddPopulation(countryCityPopulation[currCountry], currCity, currCount);
            AddPopulation(countryPopulation, currCountry, currCount);
        }

        foreach (var kvp in countryPopulation.OrderByDescending(x => x.Value))
        {
            var currCountry = kvp.Key;
            var currCountryPopulation = kvp.Value;

            Console.WriteLine($"{currCountry} (total population: {currCountryPopulation})");

            foreach (var item in countryCityPopulation[currCountry].OrderByDescending(x => x.Value))
            {
                var currCity = item.Key;
                var currPopul = item.Value;

                Console.WriteLine($"=>{currCity}: {currPopul}");
            }
        }
    }

    public static void AddPopulation(Dictionary<string, long> dictionary, string currCity, long currCount)
    {
        if (!dictionary.ContainsKey(currCity))
        {
            dictionary[currCity] = 0L;
        }

        dictionary[currCity] += currCount;
    }
}