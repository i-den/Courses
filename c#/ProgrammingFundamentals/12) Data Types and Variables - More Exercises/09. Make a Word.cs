using System;

public class Program
{
    public static void Main()
    {
        var linesCount = int.Parse(Console.ReadLine());

        var wordToPrint = string.Empty;

        for (int i = 0; i < linesCount; i++)
        {
            wordToPrint += Console.ReadLine();
        }

        Console.WriteLine($"The word is: {wordToPrint}");
    }
}