using System;

class Program
{
    public static void Main()
    {
        var product = Console.ReadLine();
        var city = Console.ReadLine();
        var amount = double.Parse(Console.ReadLine());
        var price = 0.0;

        if (city.ToLower() == "sofia")
        {
            if (product == "coffee")
                price = .5;
            if (product == "water")
                price = .8;
            if (product == "beer")
                price = 1.2;
            if (product == "sweets")
                price = 1.45;
            if (product == "peanuts")
                price = 1.60;
        }
        if (city.ToLower() == "plovdiv")
        {
            if (product == "coffee")
                price = .4;
            if (product == "water")
                price = .7;
            if (product == "beer")
                price = 1.15;
            if (product == "sweets")
                price = 1.30;
            if (product == "peanuts")
                price = 1.50;
        }
        if (city.ToLower() == "varna")
        {
            if (product == "coffee")
                price = .45;
            if (product == "water")
                price = .7;
            if (product == "beer")
                price = 1.1;
            if (product == "sweets")
                price = 1.35;
            if (product == "peanuts")
                price = 1.55;
        }
        Console.WriteLine(amount * price);
    }
}