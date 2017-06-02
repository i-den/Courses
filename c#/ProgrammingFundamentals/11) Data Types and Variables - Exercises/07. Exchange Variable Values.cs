using System;

public class Program
{
    public static void Main()
    {
        var firstNum = int.Parse(Console.ReadLine());
        var secNum = int.Parse(Console.ReadLine());

        PrintNums(firstNum, secNum, "Before");

        var tempNum = secNum;
        secNum = firstNum;
        firstNum = tempNum;

        PrintNums(firstNum, secNum, "After");

    }

    public static void PrintNums(int a, int b, string str)
    {
        Console.WriteLine($"{str}:");
        Console.WriteLine($"a = {a}");
        Console.WriteLine($"b = {b}");
    }
}