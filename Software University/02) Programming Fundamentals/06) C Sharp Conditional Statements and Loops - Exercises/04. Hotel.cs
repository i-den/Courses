using System;

public class Program
{
    public static void Main()
    {
        var month = Console.ReadLine();
        var amountOfNights = int.Parse(Console.ReadLine());

        var studioPrice = 0D;
        var doublePrice = 0D;
        var suitePrice = 0D;

        switch (month)
        {
            case "May":
            case "October":
                studioPrice = amountOfNights > 7 ? 47.5 : 50;
                doublePrice = 65;
                suitePrice = 75;
                break;
            case "June":
            case "September":
                studioPrice = 60;
                doublePrice = amountOfNights > 14 ? 64.8 : 72;
                suitePrice = 82;
                break;
            case "July":
            case "August":
            case "December":
                studioPrice = 68;
                doublePrice = 77;
                suitePrice = amountOfNights > 14 ? 75.65 : 89;
                break;
        }

        var totalStudioPrice = studioPrice * amountOfNights;
        var totalDoublePrice = doublePrice * amountOfNights;
        var totalSuitePrice = suitePrice * amountOfNights;

        if ((month == "September" || month == "October") && amountOfNights > 7)
        {
            totalStudioPrice -= studioPrice;
        }

        Console.WriteLine($"Studio: {totalStudioPrice:F2} lv.");
        Console.WriteLine($"Double: {totalDoublePrice:F2} lv.");
        Console.WriteLine($"Suite: {totalSuitePrice:F2} lv.");
    }
}