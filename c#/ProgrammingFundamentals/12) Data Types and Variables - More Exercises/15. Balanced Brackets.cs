using System;

public class Program
{
    public static void Main()
    {
        var linesCount = int.Parse(Console.ReadLine());

        var openingBracesCount = 0;
        var closingBracesCount = 0;
        var previousOpeningBracesCount = 0;
        var previousClosingBracesCount = 0;
        var previousInput = string.Empty;

        for (int i = 0; i < linesCount; i++)
        {
            var currentInput = Console.ReadLine();

            if (currentInput == "(")
            {
                openingBracesCount++;

                if (previousInput == string.Empty)
                {
                    previousInput = "(";
                }

                if (previousInput == "(")
                {
                    previousOpeningBracesCount++;
                }
                else if (previousInput == ")")
                {
                    if (previousOpeningBracesCount != previousClosingBracesCount)
                    {
                        Console.WriteLine("UNBALANCED");
                        return;
                    }
                    else
                    {
                        previousInput = "(";
                        previousOpeningBracesCount = 1;
                        previousClosingBracesCount = 0;
                    }
                }
            }
            else if (currentInput == ")")
            {
                closingBracesCount++;

                if (previousInput == string.Empty)
                {
                    Console.WriteLine("UNBALANCED");
                    return;
                }
                else if (previousInput == "(")
                {
                    previousInput = ")";
                    previousClosingBracesCount++;
                }
                else if (previousInput == ")")
                {
                    previousClosingBracesCount++;
                }
            }
        }

        if (openingBracesCount == closingBracesCount)
        {
            Console.WriteLine("BALANCED");
        }
        else
        {
            Console.WriteLine("UNBALANCED");
        }
    }
}