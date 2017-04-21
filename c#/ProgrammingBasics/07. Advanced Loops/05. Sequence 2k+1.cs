using System;

namespace _05.Sequence_2k_1
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 1, num = 1; num <= n; i++, num = num * 2 + 1)
                Console.WriteLine(num);   
        }
    }
}
