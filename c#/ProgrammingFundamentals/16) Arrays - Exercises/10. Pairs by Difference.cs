using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split().Select(int.Parse).ToArray();
        var diff = int.Parse(Console.ReadLine());

        var diffCount = 0;

        for (int i = 0; i < inputArr.Length; i++)
        {
            var currAnchorNum = inputArr[i];

            for (int j = i + 1; j < inputArr.Length; j++)
            {
                var currNum = inputArr[j];
                var currDifference = Math.Abs(currAnchorNum - currNum);

                if (currDifference == diff)
                {
                    diffCount++;
                }
            }
        }

        Console.WriteLine(diffCount);
    }
}