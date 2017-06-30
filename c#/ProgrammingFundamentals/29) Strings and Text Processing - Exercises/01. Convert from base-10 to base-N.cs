using System;
using System.Collections.Generic;
using System.Numerics;

class Problem4
{
    static void Main()
    {
        var input = Console.ReadLine().Split();
        var firstNum = int.Parse(input[0]);
        var secNum = BigInteger.Parse(input[1]);
        var result = new List<BigInteger>();

        while (secNum != 0)
        {
            var remainder = secNum % firstNum;
            result.Add(remainder);
            secNum /= firstNum;
        }

        result.Reverse();

        foreach (var number in result)
        {
            Console.Write(number);
        }
    }
}