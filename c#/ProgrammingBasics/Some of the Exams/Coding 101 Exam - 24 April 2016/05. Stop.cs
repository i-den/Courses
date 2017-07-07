using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        Console.WriteLine("{0}{1}{0}", new string('.', n + 1), new string('_', n * 2 + 1));
        for (int row = 1; row <= n; row++)
        {
            Console.WriteLine("{0}//{1}\\\\{0}", new string('.', n + 1 - row), new string('_', n * 2 - 1 + ((row - 1) * 2)));
        }
        Console.WriteLine("//{0}STOP!{0}\\\\", new string('_', ((((n + 1) * 2) + (n * 2 + 1)) - 9) / 2));

        for (int i = n; i > 0; i--)
        {
            Console.WriteLine("{0}\\\\{1}//{0}", new string('.', n - i), new string('_', n * 2 + 1 + ((i - 1) * 2)));
        }
    }
}