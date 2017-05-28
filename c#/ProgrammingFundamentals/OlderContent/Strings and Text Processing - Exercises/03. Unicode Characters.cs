using System;

public class Program
{
    public static void Main()
    {
        var inputStr = Console.ReadLine().ToCharArray();

        foreach (var hexNum in inputStr)
        {
            Console.Write($"\\u{((int)hexNum):x4}");
        }
    }
}