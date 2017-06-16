using System;
using System.Linq;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();

        while (true)
        {
            var input = Console.ReadLine().Split();

            if (input[0] == "print")
            {
                Console.WriteLine("[" + string.Join(", ", inputList) + "]");
                return;
            }

            switch (input[0])
            {
                case "add":
                    var indexToAdd = int.Parse(input[1]);
                    var numToAdd = int.Parse(input[2]);
                    inputList.Insert(indexToAdd, numToAdd);
                    break;
                case "addMany":
                    var indexToAddTo = int.Parse(input[1]);
                    var numsToAdd = input.Skip(2).Select(int.Parse).ToList();
                    inputList.InsertRange(indexToAddTo, numsToAdd);
                    break;
                case "contains":
                    var numToPrint = int.Parse(input[1]);
                    Console.WriteLine(inputList.IndexOf(numToPrint));
                    break;
                case "remove":
                    var indexToRemoveAt = int.Parse(input[1]);
                    inputList.RemoveAt(indexToRemoveAt);
                    break;
                case "shift":
                    var shiftNums = int.Parse(input[1]);
                    inputList = inputList.Skip(shiftNums).Concat(inputList.Take(shiftNums)).ToList();
                    break;
                case "sumPairs":
                    if (inputList.Count % 2 == 0)
                    {
                        inputList = GetInputList(inputList);
                    }
                    else
                    {
                        inputList.Add(0);
                        inputList = GetInputList(inputList);
                    }
                    break;
            }
        }

    }

    private static List<int> GetInputList(List<int> inputList)
    {
        inputList = inputList
                                .Where((x, index) => index % 2 == 0)
                                .Zip(inputList.Where((x, index) => index % 2 == 1), (x, y) => x + y)
                                .ToList();
        return inputList;
    }
}