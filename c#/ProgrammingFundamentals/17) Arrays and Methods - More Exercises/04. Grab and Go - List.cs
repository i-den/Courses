using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();
        var numToFind = int.Parse(Console.ReadLine());

        var index = inputList.LastIndexOf(numToFind);

        if (index > 0)
        {
            inputList.RemoveRange(index, inputList.Count - index);
            Console.WriteLine(inputList.Sum());
        }
        else
        {
            Console.WriteLine("No occurrences were found!");
        }
    }
}