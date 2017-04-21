using System;

namespace _04.Triangle_of_Dollars
{
    class Program
    {
        static void Main()
        {
            var n = int.Parse(Console.ReadLine());

            for (int row = 0; row < n; row++)
            {
                Console.Write("$");

                for (int col = 0; col < row; col++)
                    Console.Write(" $");
                Console.WriteLine();
            }

        }
    }
}
