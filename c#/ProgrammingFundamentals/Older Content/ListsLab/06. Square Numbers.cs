using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var myList = Console.ReadLine().Split().Select(int.Parse).ToList();
        var resultsList = new List<int>();

        for (int i = 0; i < myList.Count; i++)
        {
            var currNumber = myList[i];

            if (Math.Sqrt(currNumber) == (int)Math.Sqrt(currNumber))
            {
                resultsList.Add(currNumber);
            }
        }

        resultsList.Sort((a, b) => b.CompareTo(a));

        Console.WriteLine(string.Join(" ", resultsList));
    }
}