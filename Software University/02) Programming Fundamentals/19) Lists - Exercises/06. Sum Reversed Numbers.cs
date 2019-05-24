using System;
using System.Linq;

class Program
{
    static void Main()
    {
        Console.WriteLine(Console.ReadLine()
            .Split()
            .Select(x => ReverseNum(x))
            .ToList()
            .Sum());
    }

    public static int ReverseNum(string arg)
    {
        return int.Parse(string.Join("", arg.Reverse().ToArray()));
    }
}