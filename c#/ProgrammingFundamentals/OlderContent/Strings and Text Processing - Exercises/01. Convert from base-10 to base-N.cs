using System;
using System.Numerics;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var inputNumbers = Console.ReadLine().Split();

        var firstNum = int.Parse(inputNumbers[0]);
        var secNum = BigInteger.Parse(inputNumbers[1]);
        var resultNumbersList = new List<BigInteger>();

        while (secNum != 0)
        {
            resultNumbersList.Add(secNum % firstNum);
            secNum /= firstNum;
        }

        resultNumbersList.Reverse();

        foreach (var number in resultNumbersList)
        {
            Console.Write(number);
        }
    }
}