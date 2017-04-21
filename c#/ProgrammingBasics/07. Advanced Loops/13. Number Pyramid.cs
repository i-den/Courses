using System;

namespace _13.Number_Pyramid
{
    class Program
    {
        static void Main()
        {
            var n = int.Parse(Console.ReadLine());

            for (int row = 1, num = row; row <= n; row++)
            {
                for (int col = 1; col <= row; col++, num ++)
                {
                    if (num == n + 1) break;
                    if (col == 1) Console.Write(num);
                    else
                        Console.Write(" " +num);                    
                }
                Console.WriteLine();
            }

            
        }
    }
}
