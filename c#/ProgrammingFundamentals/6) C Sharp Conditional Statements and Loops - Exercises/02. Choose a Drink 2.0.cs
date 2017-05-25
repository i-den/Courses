using System;

public class Program
{
    public static void Main()
    {
        var input = Console.ReadLine();
        var amountOfDrinks = int.Parse(Console.ReadLine());
        var price = 0D;

        switch (input)
        {
            case "Athlete":
                price = 0.7; break;
            case "Businessman":
            case "Businesswoman":
                price = 1D; break;
            case "SoftUni Student":
                price = 1.7; break;
            default:
                price = 1.2; break;
        }

        var amountToPay = price * amountOfDrinks;

        Console.WriteLine($"The {input} has to pay {amountToPay:F2}.");
    }
}
