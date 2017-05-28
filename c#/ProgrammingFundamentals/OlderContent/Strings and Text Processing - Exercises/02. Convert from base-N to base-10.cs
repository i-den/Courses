using System;
using System.Collections.Generic;
using System.Numerics;

class Problem
{
    static void Main()
    {
        var inputNumbers = Console.ReadLine().Trim().Split();

        var firstNum = int.Parse(inputNumbers[0]);
        var secNum = inputNumbers[1].ToCharArray();
        var result = new BigInteger(0);

        for (int i = 0; i < inputNumbers[1].Length; i++)
        {
            var currentNumber = (int)char.GetNumericValue(secNum[i]);

            result += currentNumber * BigInteger.Pow(firstNum, secNum.Length - 1 - i);
        }

        Console.WriteLine(result);
    }
}