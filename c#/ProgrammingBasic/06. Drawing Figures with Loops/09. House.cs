using System;

class Program
{
    public static void Main()
    {
        var num = int.Parse(Console.ReadLine());

        if (num % 2 == 1)
            HeaderA(num);
        else
            HeaderB(num);

        Footer(num);
    }

    private static void HeaderB(int num)
    {
        for (int row = 0; row < num / 2; row++)
        {
            Console.Write(new string('-', num / 2 - 1 - row));
            Console.Write(new string('*', 2 + row * 2));
            Console.Write(new string('-', num / 2 - 1 - row));

            Console.WriteLine();
        }
    }

    private static void HeaderA(int num)
    {
        for (int row = 0; row < (num + 1) / 2; row++)
        {
            Console.Write(new string('-', num / 2 - row));
            Console.Write(new string('*', 1 + row * 2));
            Console.Write(new string('-', num / 2 - row));
            Console.WriteLine();
        }
    }

    private static void Footer(int num)
    {
        for (int i = 0; i < num / 2; i++)
        {
            Console.WriteLine("|{0}|", new string('*', num - 2));
        }
    }
}