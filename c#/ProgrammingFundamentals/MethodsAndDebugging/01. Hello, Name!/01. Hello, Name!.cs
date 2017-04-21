using System;

public class Program
{
    public static void Main()
    {
        PrintName();
    }

    public static void PrintName()
    {
        string name = Console.ReadLine();
        Console.WriteLine($"Hello, {name}!");
    }
}
