using System;
using System.Collections.Generic;
using System.Numerics;

class Problem4
{
    static void Main()
    {
        var input = Console.ReadLine().Trim().Split();
        var firstNum = int.Parse(input[0]);
        var secNum = input[1].ToCharArray();
        var result = new BigInteger(0);

        for (int i = 0; i < input[1].Length; i++)
        {
            var currNum = (int)char.GetNumericValue(secNum[i]);
            result += currNum * BigInteger.Pow(firstNum, secNum.Length - i - 1);
        }

        Console.WriteLine(result);
    }
}