using System;

class Program
{
    public static void Main()
    {
        var num = int.Parse(Console.ReadLine());

        Wrapper(num);

        for (int row = 0; row < num - 2; row++)
        {
            Body(num);
            Mid(num, row);
            Body(num);
            Console.WriteLine();
        }

        Wrapper(num);
    }

    private static void Mid(int num, int row)
    {
        if (row == (num + 1) / 2 - 2)
            Console.Write(new string('|', num));
        else
            Console.Write(new string(' ', num));
    }

    private static void Body(int num)
    {
        Console.Write("*");
        for (int col1 = 0; col1 < num * 2 - 2; col1++)
        {
            Console.Write("/");
        }
        Console.Write("*");
    }

    private static void Wrapper(int num)
    {
        Console.WriteLine("{0}{1}{0}", new string('*', num * 2), new string(' ', num));
    }
}