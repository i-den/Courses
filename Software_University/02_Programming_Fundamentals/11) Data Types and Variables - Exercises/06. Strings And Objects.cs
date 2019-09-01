using System;

public class Program
{
    public static void Main()
    {
        var firstInput = Console.ReadLine();
        var secInput = Console.ReadLine();

        object concatenatedStrings = string.Concat(firstInput + " ", secInput);

        var result = (string)concatenatedStrings;

        Console.WriteLine(result);
    }
}