using System;

public class Program
{
    public static void Main()
    {
        var inputGrade = double.Parse(Console.ReadLine());

        if (inputGrade >= 3)
        {
            Console.WriteLine("Passed!");
        }
    }
}