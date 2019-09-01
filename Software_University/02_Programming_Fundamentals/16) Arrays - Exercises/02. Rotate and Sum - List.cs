using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).ToList();
        var shiftsCount = int.Parse(Console.ReadLine());

        var resulstsList = new List<long>(new long[inputList.Count]);

        for (int i = 0; i < shiftsCount; i++)
        {
            var oldLastDigit = inputList.Last();
            inputList.Remove(inputList.Last());
            inputList.Insert(0, oldLastDigit);

            resulstsList = inputList.Zip(resulstsList, (x, y) => x + y).ToList();
        }

        Console.WriteLine(string.Join(" ", resulstsList));
    }
}