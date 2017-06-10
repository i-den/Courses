using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine();

        for (int i = 0; i < inputArr.Length; i++)
        {
            var currentNum = (int)inputArr[i] - 97;

            Console.WriteLine($"{inputArr[i]} -> {currentNum}");
        }
    }
}