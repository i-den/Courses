using System;

public class Program
{
    public static void Main()
    {
        var input = int.Parse(Console.ReadLine());

        var toHex = input.ToString("X");
        var toBinary = Convert.ToString(input, 2);

        Console.WriteLine(toHex);
        Console.WriteLine(toBinary);
    }
}