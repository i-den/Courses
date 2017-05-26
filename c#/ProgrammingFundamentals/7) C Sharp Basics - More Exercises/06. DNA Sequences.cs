using System;

public class Program
{
    public static void Main()
    {
        var matchSum = int.Parse(Console.ReadLine());
        var newLineCounter = 0;

        for (int firstIndex = 1; firstIndex <= 4; firstIndex++)
        {
            for (int secondIndex = 1; secondIndex <= 4; secondIndex++)
            {
                for (int thirdIndex = 1; thirdIndex <= 4; thirdIndex++)
                {
                    var firstNuc = GetNucChar(firstIndex);
                    var secNuc = GetNucChar(secondIndex);
                    var thirdNuc = GetNucChar(thirdIndex);
                    var wrapper = (firstIndex + secondIndex + thirdIndex) >= matchSum ? "O" : "X";

                    Console.Write($"{wrapper}{firstNuc}{secNuc}{thirdNuc}{wrapper} ");
                    newLineCounter++;

                    if (newLineCounter % 4 == 0)
                    {
                        Console.WriteLine();
                    }
                }
            }
        }
    }

    public static char GetNucChar(int indexNum)
    {
        char charToReturn = 'a';

        switch (indexNum)
        {
            case 1:
                charToReturn = 'A';
                break;
            case 2:
                charToReturn = 'C';
                break;
            case 3:
                charToReturn = 'G';
                break;
            case 4:
                charToReturn = 'T';
                break;
        }

        return charToReturn;
    }
}