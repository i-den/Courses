using System;

namespace _01.Rectangle_of_10_x_10_Stars
{
    class Program
    {
        static void Main()
        {
            int n = 10;
            for (int rows = 0; rows < n; rows++)
                Console.WriteLine(new string('*', n));
        }
    }
}
