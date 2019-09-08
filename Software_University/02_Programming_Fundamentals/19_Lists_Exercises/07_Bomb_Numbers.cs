using System;
using System.Linq;

class Program
{
    static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();
        var numsInfo = Console.ReadLine().Split().Select(int.Parse).ToList();
        var numToFind = numsInfo[0];
        var numSide = numsInfo[1];

        while (true)
        {
            var indexOfList = inputList.IndexOf(numToFind);

            if (indexOfList < 0)
            {
                break;
            }

            var indexToStart = indexOfList - numSide;
            var lengthToRemove = numSide * 2 + 1;

            if (indexToStart < 0)
            {
                indexToStart = 0;
            }

            if (indexToStart + lengthToRemove >= inputList.Count())
            {
                lengthToRemove = inputList.Count() - indexToStart;
            }

            inputList.RemoveRange(indexToStart, lengthToRemove);
        }

        Console.WriteLine(inputList.Sum());
    }
}