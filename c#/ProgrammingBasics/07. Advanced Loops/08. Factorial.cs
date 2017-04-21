using System;

namespace _08.Factorial
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            for (long i = 1, num = 1; i <= n; i++, num = num * i)
                if (i == n)
                    Console.WriteLine(num);
        }
    }
}
 