using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();
        var divNum = inputList.Count / 4;

        var leftList = inputList.Take(divNum).Reverse().ToList();
        var rightList = inputList.Skip(inputList.Count / 4 + inputList.Count / 2).Reverse().ToList();

        var topList = leftList.Concat(rightList).ToList();
        var midList = inputList.Skip(divNum).Take(divNum * 2).ToList();

        var resultsList = topList.Zip(midList, (x, y) => x + y).ToList();

        Console.WriteLine(string.Join(" ", resultsList));
    }
}