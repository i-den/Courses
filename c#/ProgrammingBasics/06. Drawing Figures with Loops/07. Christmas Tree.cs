using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        for (int row = 1; row <= n; row++)
        {
            for (int col = 1; col <= n - row; col++) Console.Write(" ");
            for (int col2 = 2; col2 <= row; col2++) Console.Write("*");
            Console.Write(" | ");
            for (int col2 = 2; col2 <= row; col2++) Console.Write("*");
            for (int col = 1; col <= n - row; col++) Console.Write(" ");
            Console.WriteLine();
        }
    }
}