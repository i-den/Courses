using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Split().ToList();
        int sumResult = 0;

        for (int i = 0; i < inputList.Count; i++)
        {
            var currentNumber = int.Parse(GetCurrentReversedNumber(inputList[i]));

            sumResult += currentNumber;
        }

        Console.WriteLine(sumResult);
    }

    public static string GetCurrentReversedNumber(string v)
    {
        var charArray = v.ToCharArray();
        Array.Reverse(charArray);
        return new string(charArray);
    }
}