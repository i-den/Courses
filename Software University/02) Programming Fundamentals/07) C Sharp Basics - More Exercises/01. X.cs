using System;

public class Program
{
    public static void Main()
    {
        var inputNumber = int.Parse(Console.ReadLine());

        for (int i = 0; i < inputNumber / 2; i++)
        {
            Console.WriteLine("{0}x{1}x{0}", new string(' ', i), new string(' ', inputNumber - (2 + i * 2)));
        }

        Console.WriteLine("{0}x{0}", new string(' ', inputNumber / 2));

        for (int i = inputNumber / 2; i > 0; i--)
        {
            Console.WriteLine("{0}x{1}x{0}", new string(' ', i - 1), new string(' ', inputNumber - 2 * i));
        }
    }
}