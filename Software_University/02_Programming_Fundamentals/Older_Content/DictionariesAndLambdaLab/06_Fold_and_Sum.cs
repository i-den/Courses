using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Split().Select(int.Parse).ToArray();

        var k = inputArr.Length / 4;

        var leftSide = inputArr.Take(k).Reverse().ToArray();
        var rightSide = inputArr.Reverse().Take(k).ToArray();
        var upperRow = leftSide.Concat(rightSide).ToArray();
        var bottomRow = inputArr.Skip(k).Take(k * 2).ToArray();

        var result = upperRow.Zip(bottomRow, (x, y) => x + y);

        Console.WriteLine(string.Join(" ", result));
        }
}