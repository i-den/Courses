using System;

public class Program
{
    public static void Main()
    {
        var firstChar = char.Parse(Console.ReadLine());
        var secondChar = char.Parse(Console.ReadLine());
        var notIncludedChar = char.Parse(Console.ReadLine());

        for (int firstIndex = firstChar; firstIndex <= secondChar; firstIndex++)
        {
            for (int secondIndex = firstChar; secondIndex <= secondChar; secondIndex++)
            {
                for (int thirdIndex = firstChar; thirdIndex <= secondChar; thirdIndex++)
                {
                    if (firstIndex != notIncludedChar && secondIndex != notIncludedChar && thirdIndex != notIncludedChar)
                    {
                        Console.Write($"{(char)firstIndex}{(char)secondIndex}{(char)thirdIndex} ");
                    }
                }
            }
        }

    }
}