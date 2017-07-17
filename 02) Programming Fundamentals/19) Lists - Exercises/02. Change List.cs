using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();

        while (true)
        {
            var input = Console.ReadLine().Split();

            if (input[0] == "Even" || input[0] == "Odd")
            {
                switch (input[0])
                {
                    case "Odd":
                        PrintNums(inputList, 1);
                        break;
                    case "Even":
                        PrintNums(inputList, 0);
                        break;
                }
                return;
            }

            switch (input[0])
            {
                case "Delete":
                    var numToDelete = int.Parse(input[1]);
                    inputList.RemoveAll(x => x == numToDelete);
                    break;
                case "Insert":
                    var elementToInsert = int.Parse(input[1]);
                    var indexToInsertIn = int.Parse(input[2]);
                    inputList.Insert(indexToInsertIn, elementToInsert);
                    break;
            }
        }
    }

    public static void PrintNums(List<int> inputList, int rem)
    {
        foreach (var currNum in inputList.Where(x => x % 2 == rem))
        {
            Console.Write($"{currNum} ");
        }
    }
}