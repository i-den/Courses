using System;

public class Program
{
    public static void Main()
    {
        var inputKey = int.Parse(Console.ReadLine());
        var linesCount = int.Parse(Console.ReadLine());

        var wordToPrint = string.Empty;

        for (int i = 0; i < linesCount; i++)
        {
            var currentInputChar = char.Parse(Console.ReadLine());
            var currentCharToAdd = (char)(currentInputChar + inputKey);

            wordToPrint += currentCharToAdd;
        }

        Console.WriteLine(wordToPrint);
    }
}