using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.Christmas_Tree
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            for (int row = 1; row <= n; row++)
            {
                for (int col = 1; col <= n - row; col++) Console.Write(" ");
                for (int col2 = 2; col2 <= row; col2++) Console.Write("*");
                Console.Write(" | ");
                for (int col2 = 2; col2 <= row; col2++) Console.Write("*");
                for (int col = 1; col <= n - row; col++) Console.Write(" ");
                Console.WriteLine();
            }
        }
    
        }
    }

