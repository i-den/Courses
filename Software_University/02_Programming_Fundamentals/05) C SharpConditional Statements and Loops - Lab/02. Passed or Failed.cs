using System;

public class Program
{
    public static void Main()
    {
        var inputGrade = double.Parse(Console.ReadLine());

        var result = inputGrade >= 3 ? "Passed!" : "Failed!";

        Console.WriteLine(result);
    }
}