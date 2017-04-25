using System;
using System.Linq;

public class Program
{
    public static void Main()
    {

        char[] charArrayOne = Console.ReadLine().Split().Select(char.Parse).ToArray();
        char[] charArrayTwo = Console.ReadLine().Split().Select(char.Parse).ToArray();

        int smallerArrayLength = Math.Min(charArrayOne.Length, charArrayTwo.Length);
        bool areEqual = false;

        for (int i = 0; i < smallerArrayLength; i++)
        {
            if (charArrayOne[i] == charArrayTwo[i])
            {
                continue;
            }
            else if (charArrayOne[i] < charArrayTwo[i])
            {
                PrintFirstResult(charArrayOne, charArrayTwo);
            }
            else
            {
                PrintSecondResult(charArrayOne, charArrayTwo);
            }

            areEqual = true;
            break;
        }

        if (!areEqual)
        {
            if (charArrayOne.Length <= charArrayTwo.Length)
            {
                PrintFirstResult(charArrayOne, charArrayTwo);
            }
            else
            {
                PrintSecondResult(charArrayOne, charArrayTwo);
            }
        }
    }

    private static void PrintSecondResult(char[] charArrayOne, char[] charArrayTwo)
    {
        Console.WriteLine(charArrayTwo);
        Console.WriteLine(charArrayOne);
    }

    private static void PrintFirstResult(char[] charArrayOne, char[] charArrayTwo)
    {
        Console.WriteLine(charArrayOne);
        Console.WriteLine(charArrayTwo);
    }
}