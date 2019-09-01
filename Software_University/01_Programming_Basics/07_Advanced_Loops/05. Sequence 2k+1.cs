using System;

class Program
{
    public static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        for (int i = 1, num = 1; num <= n; i++, num = num * 2 + 1)
            Console.WriteLine(num);
    }
}