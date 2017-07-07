using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        for (int row = 1; row <= n; row++)
        {
            for (int col = 0; col < n - row; col++) Console.Write(" ");
            Console.Write("*");
            for (int col = 0; col < row - 1; col++) Console.Write("-*");
            Console.WriteLine();
        }

        for (int row = n - 1; row >= 1; row--)
        {
            for (int col = 1; col <= n - row; col++) Console.Write(" ");
            Console.Write("*");
            for (int i = 1; i <= row - 1; i++) Console.Write("-*");
            Console.WriteLine();
        }
    }
}