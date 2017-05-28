using System;

public class Program
{
    public static void Main()
    {
        var input = Console.ReadLine().Trim().Split(new char[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries);
        
        var sum = 0m;

        for (int i = 0; i < input.Length; i++)
        {
            sum += GetSum(input[i]);
        }

        Console.WriteLine($"{sum:F2}");
    }

    public static decimal GetSum(string number)
    {
        var firstLetter = number[0];
        var firstLetterAlphabetPosition = GetAlphabetPosition(firstLetter);
        var lastLetter = number[number.Length - 1];
        var lastLetterAlphabetPosition = GetAlphabetPosition(lastLetter);
        var currNumber = decimal.Parse(number.Substring(1, number.Length - 2));


        if (char.IsUpper(firstLetter))
        {
            currNumber /= firstLetterAlphabetPosition;
        }
        else
        {
            currNumber *= firstLetterAlphabetPosition;
        }

        if (char.IsUpper(lastLetter))
        {
            currNumber -= lastLetterAlphabetPosition; 
        }
        else
        {
            currNumber += lastLetterAlphabetPosition;
        }

        return currNumber;
    }

    public static decimal GetAlphabetPosition(char firstLetter)
    {
        if (char.IsUpper(firstLetter))
        {
            return (decimal)(firstLetter - 64);
        }
        else
        {
            return (decimal)(firstLetter - 96);
        }
    }
}