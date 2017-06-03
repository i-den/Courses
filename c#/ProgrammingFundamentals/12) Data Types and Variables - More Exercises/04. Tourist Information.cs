using System;

public class Program
{
    public static void Main()
    {
        var inputParameter = Console.ReadLine();
        var inputValue = decimal.Parse(Console.ReadLine());

        var outputParameter = string.Empty;
        var multiplier = 0m;

        switch (inputParameter)
        {
            case "miles":
                multiplier = 1.6m;
                outputParameter = "kilometers";
                break;
            case "inches":
                multiplier = 2.54m;
                outputParameter = "centimeters";
                break;
            case "feet":
                multiplier = 30m;
                outputParameter = "centimeters";
                break;
            case "yards":
                multiplier = 0.91m;
                outputParameter = "meters";
                break;
            case "gallons":
                multiplier = 3.8m;
                outputParameter = "liters";
                break;
        }

        var convertedValue = inputValue * multiplier;

        Console.WriteLine($"{inputValue} {inputParameter} = {convertedValue:F2} {outputParameter}");
    }
}