using System;

public class Program
{
    public static void Main()
    {
        var input = Console.ReadLine();
        var result = string.Empty;

        switch (input)
        {
            case "Athlete":
                result = "Water"; break;
            case "Businessman":
            case "Businesswoman":
                result = "Coffee"; break;
            case "SoftUni Student":
                result = "Beer"; break;
            default:
                result = "Tea"; break;
        }

        Console.WriteLine(result);
    }
}
