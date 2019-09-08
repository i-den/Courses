using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var myIntList = Console.ReadLine().Split().Select(int.Parse).ToList();

        myIntList = myIntList.Where(x => x > 0).Reverse().ToList();

        if (myIntList.Count() != 0)
        {
            Console.WriteLine(string.Join(" ", myIntList));
        }
        else
        {
            Console.WriteLine();
        }
    }
}