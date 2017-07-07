using System;

class Program
{
    public static void Main()
    {
        double budget = double.Parse(Console.ReadLine());
        string season = Console.ReadLine().ToLower();
        var money = 0.0;
        string destination;
        string type;

        if (season == "summer")
            type = "Camp";
        else
            type = "Hotel";

        if (budget <= 100)
        {
            destination = "Bulgaria";
            if (season == "summer")
                money = (double)budget * 0.3;
            else
                money = (double)budget * 0.7;
        }
        else if (budget <= 1000)
        {
            destination = "Balkans";
            if (season == "summer")
                money = (double)budget * 0.4;
            else
                money = (double)budget * 0.8;
        }
        else
        {
            destination = "Europe";
            type = "Hotel";
            money = (double)budget * 0.9;
        }

        Console.WriteLine("Somewhere in {0}", destination);
        Console.WriteLine($"{type} - {money:f2}");
    }
}