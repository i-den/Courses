using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var myList = Console.ReadLine().Split().Select(decimal.Parse).ToList();

        myList.Sort();

        Console.WriteLine(string.Join(" <= ", myList));
    }
}