using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split().Select(int.Parse).ToArray();
        var sum = inputArr[0];
        var currentPosition = 0;

        while (true)
        {
            if (currentPosition + inputArr[currentPosition] < inputArr.Length)
            {
                currentPosition += inputArr[currentPosition];
                sum += inputArr[currentPosition];
            }
            else
            {
                break;
            }
        }

        while (true)
        {
            if (currentPosition - inputArr[currentPosition] >= 0)
            {
                currentPosition -= inputArr[currentPosition];
                sum += inputArr[currentPosition];
            }
            else
            {
                break;
            }
        }

        Console.WriteLine(sum);
    }
}