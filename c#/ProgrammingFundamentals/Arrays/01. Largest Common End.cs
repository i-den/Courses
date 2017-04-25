using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var arrayOne = Console.ReadLine().Split().ToArray();
        var arrayTwo = Console.ReadLine().Split().ToArray();

        int minimumArrayLength = Math.Min(arrayOne.Length, arrayTwo.Length);

        int leftCounter = GetRepetitiveStringsCount(arrayOne, arrayTwo, minimumArrayLength);

        Array.Reverse(arrayOne);
        Array.Reverse(arrayTwo);
        
        int rightCounter = GetRepetitiveStringsCount(arrayOne, arrayTwo, minimumArrayLength);

        Console.WriteLine(Math.Max(leftCounter, rightCounter));
    }

    public static int GetRepetitiveStringsCount(string[] arrayOne, string[] arrayTwo, int minimumArrayLength)
    {
        int repetitiveStringsCount = 0;

        for (int i = 0; i < minimumArrayLength; i++)
        {
            if (arrayOne[i] == arrayTwo[i])
            {
                repetitiveStringsCount++;
            }
            else
            {
                break;
            }
        }

        return repetitiveStringsCount;
    }
}