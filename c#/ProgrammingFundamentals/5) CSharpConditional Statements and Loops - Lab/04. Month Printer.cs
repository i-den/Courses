using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var month = int.Parse(Console.ReadLine());

        var monthNumberDict = new Dictionary<int, string>
        {
            { 1, "January" },
            { 2, "February" },
            { 3, "March" },
            { 4, "April" },
            { 5, "May" },
            { 6, "June" },
            { 7, "July" },
            { 8, "August" },
            { 9, "September" },
            { 10, "October" },
            { 11, "November" },
            { 12, "December" }
        };

        if (monthNumberDict.ContainsKey(month))
        {
            Console.WriteLine(monthNumberDict[month]);
        }
        else
        {
            Console.WriteLine("Error!");
        }

    }
}