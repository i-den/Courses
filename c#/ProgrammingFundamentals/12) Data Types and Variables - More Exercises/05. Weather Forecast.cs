using System;

public class Program
{
    public static void Main()
    {
        var inputNumber = Console.ReadLine();

        var weather = string.Empty;
        var dummySbyte = default(sbyte);
        var dummyInt = default(int);
        var dummyLong = default(long);

        if (sbyte.TryParse(inputNumber, out dummySbyte))
        {
            weather = "Sunny";
        }
        else if (int.TryParse(inputNumber, out dummyInt))
        {
            weather = "Cloudy";
        }
        else if (long.TryParse(inputNumber, out dummyLong))
        {
            weather = "Windy";
        }
        else
        {
            weather = "Rainy";
        }

        Console.WriteLine(weather);
    }
}