using System;

public class Program
{
    public static void Main()
    {
        var input = Convert.ToBoolean(Console.ReadLine());

        var result = input ? "Yes" : "No";

        Console.WriteLine(result);
    }
}