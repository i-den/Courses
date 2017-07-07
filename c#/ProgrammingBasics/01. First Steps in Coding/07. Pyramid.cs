using System;

class Program
{
    public static void Main()
    {
        for (int i = 1; i < 10; i++)
        {
            Console.WriteLine(new string(' ', 10 - i) + new string('*', i * 2));
        }
        for (int i = 10; i >= 1; i--)
        {
            Console.WriteLine(new string(' ', 10 - i) + new string('*', i * 2));
        }
    }
}