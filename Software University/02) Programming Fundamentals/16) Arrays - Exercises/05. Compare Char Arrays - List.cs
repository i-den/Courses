using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var firstArr = string.Join("", Console.ReadLine().Split());
        var secArr = string.Join("", Console.ReadLine().Split());

        var myList = new List<string>{ firstArr, secArr };

        foreach (var currArr in myList.OrderBy(a => a))
        {
            Console.WriteLine(currArr);
        }
    }
}