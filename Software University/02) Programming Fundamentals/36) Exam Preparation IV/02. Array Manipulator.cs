using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var myList = Console.ReadLine().Split().Select(int.Parse).ToList();

        while (true)
        {
            var input = Console.ReadLine().Split();

            if (input[0] == "end")
            {
                break;
            }

            switch (input[0])
            {
                case "exchange":
                    var currIndex = int.Parse(input[1]);

                    if (currIndex < 0 || currIndex >= myList.Count)
                    {
                        Console.WriteLine("Invalid index");
                        break;
                    }

                    myList = ExchangeList(myList, input, currIndex + 1);
                    break;
                case "max":
                case "min":
                    Console.WriteLine(GetMinMaxIndex(myList, input));
                    break;
                case "first":
                case "last":
                    Console.WriteLine(GetFirstLastNums(myList, input));
                    break;
            }
        }

        Console.WriteLine("[" + string.Join(", ", myList) + "]");
    }

    public static List<int> ExchangeList(List<int> myList, string[] input, int currIndex)
    {
        return myList = myList.Skip(currIndex).Concat(myList.Take(currIndex)).ToList();
    }

    public static string GetMinMaxIndex(List<int> myList, string[] input)
    {
        var rem = input[1] == "even" ? 0 : 1;
        var filteredList = myList.Where(x => x % 2 == rem).ToList();

        if (!filteredList.Any())
        {
            return "No matches";
        }

        return input[0] == "max"
            ? myList.LastIndexOf(filteredList.ToList().Max()).ToString()
            : myList.LastIndexOf(filteredList.ToList().Min()).ToString();
    }

    public static string GetFirstLastNums(List<int> myList, string[] input)
    {
        var rem = input[2] == "even" ? 0 : 1;
        var count = int.Parse(input[1]);

        if (count > myList.Count)
        {
            return "Invalid count";
        }

        var filteredList = myList.Where(x => x % 2 == rem).ToArray();

        return input[0] == "first"
        ? "[" + string.Join(", ", filteredList.Take(count).ToList()) + "]"
        : "[" + string.Join(", ", filteredList.Reverse().Take(count).Reverse()) + "]";
    }
}