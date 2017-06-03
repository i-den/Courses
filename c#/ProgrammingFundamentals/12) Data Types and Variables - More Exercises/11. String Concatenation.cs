using System;

public class Program
{
    public static void Main()
    {
        var delimiter = char.Parse(Console.ReadLine());
        var oddOrEven = Console.ReadLine() == "even" ? 0 : 1;
        var linesCount = int.Parse(Console.ReadLine());

        var wordToPrint = string.Empty;

        for (int i = 1; i <= linesCount; i++)
        {
            var currentString = Console.ReadLine();

            if (i % 2 == oddOrEven)
            {
                wordToPrint += currentString + delimiter;
            }
        }

        Console.WriteLine(wordToPrint.TrimEnd(delimiter));
    }
}