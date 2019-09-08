using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var citiesForecast = new Dictionary<string, Forecast>();
        var regexPattern = @"(?<name>[A-Z]{2})(?<temp>[0-9]{1,}[.][0-9]{1,})(?<type>[a-zA-Z]+)(?=\|)";

        while (true)
        {
            var input = Console.ReadLine();

            if (input == "end")
            {
                break;
            }

            if (!Regex.IsMatch(input, regexPattern))
            {
                continue;
            }

            var tokens = Regex.Match(input, regexPattern);

            var city = tokens.Groups["name"].Value;
            var temp = double.Parse(tokens.Groups["temp"].Value);
            var weather = tokens.Groups["type"].Value;

            var currForecast = new Forecast
            {
                Temperature = temp,
                Weather = weather
            };

            citiesForecast[city] = currForecast;
        }

        foreach (var currCityForecast in citiesForecast
            .OrderBy(f => f.Value.Temperature))
        {
            var city = currCityForecast.Key;
            var temp = currCityForecast.Value.Temperature;
            var type = currCityForecast.Value.Weather;

            Console.WriteLine($"{city} => {temp:F2} => {type}");
        }
    }
}

internal class Forecast
{
    public double Temperature { get; set; }

    public string Weather { get; set; }
}