using System;

namespace _04.Greater_Number
{
    class Program
    {
        static void Main()
        {
            var a = double.Parse(Console.ReadLine());
            var b = double.Parse(Console.ReadLine());
            Abs(a, b);
        }

        private static void Abs(double a, double b)
        {
            if (a >= b)
                Console.WriteLine(a);
            else
                Console.WriteLine(b);
        }
    }
}
