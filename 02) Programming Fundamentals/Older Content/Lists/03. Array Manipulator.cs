using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();

        while (true)
        {
            var command = Console.ReadLine().Split().ToList();

            if (command[0] == "add")
            {
                Add(inputList, command);
            }
            else if (command[0] == "addMany")
            {
                AddMany(inputList, command);
            }
            else if (command[0] == "contains")
            {
                Contains(inputList, command);
            }
            else if (command[0] == "remove")
            {
                Remove(inputList, command);
            }
            else if (command[0] == "shift")
            {
                Shift(inputList, command);
            }
            else if (command[0] == "sumPairs")
            {
                SumPairs(inputList);
            }
            else if (command[0] == "print")
            {
                Console.WriteLine("[" + string.Join(", ", inputList) + "]");
                break;
            }
        }
    }

    public static void Add(List<int> inputList, List<string> command)
    {
        var index = int.Parse(command[1]);
        var number = int.Parse(command[2]);
        inputList.Insert(index, number);
    }

    public static void AddMany(List<int> inputList, List<string> command)
    {
        var index = int.Parse(command[1]);

        for (int i = command.Count - 1; i > 1; i--)
        {
            var number = int.Parse(command[i]);
            inputList.Insert(index, number);
        }
    }

    public static void Contains(List<int> inputList, List<string> command)
    {
        var number = int.Parse(command[1]);
        var index = 0;
        bool contains = false;

        for (int i = 0; i < inputList.Count; i++)
        {
            if (inputList[i] == number)
            {
                contains = true;
                index = i;
                break;
            }
        }

        Console.WriteLine("{0}", contains ? index : -1);
    }

    public static void Remove(List<int> inputList, List<string> command)
    {
        var number = int.Parse(command[1]);

        inputList.RemoveAt(number);
    }

    public static void Shift(List<int> inputList, List<string> command)
    {
        var numberOfShifts = int.Parse(command[1]);

        for (int i = 0; i < numberOfShifts; i++)
        {
            var oldFirstNumber = inputList.First();

            for (int j = 0; j < inputList.Count; j++)
            {
                if (j + 1 < inputList.Count)
                {
                    inputList[j] = inputList[j + 1];
                }
            }

            inputList[inputList.Count - 1] = oldFirstNumber;
        }
    }

    public static void SumPairs(List<int> inputList)
    {
        for (int i = 0; i < inputList.Count; i++)
        {
            if (i + 1 < inputList.Count)
            {
                inputList[i] += inputList[i + 1];
                inputList.RemoveAt(i + 1);
            }
        }
    }
}